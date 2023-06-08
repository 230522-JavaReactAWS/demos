import com.revature.daos.RoleDAO;
import com.revature.models.Role;
import com.revature.service.RoleService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RoleServiceTest {

    // We're mocking the DAO to prevent calls to the actual DB
    RoleDAO mockRoleDao = mock(RoleDAO.class);
    RoleService roleService = new RoleService(mockRoleDao);

    @Test
    public void getRoleByIdZero(){
        // What should we get when we pass zero to this method?
        // Zero shouldn't pass the if condition, so we should be able to just verify null

        assertNull(roleService.getRoleById(0));
    }

    @Test
    public void getRoleByIdNegativeInt(){
        // What should we get when we pass zero to this method?
        // Zero shouldn't pass the if condition, so we should be able to just verify null

        assertNull(roleService.getRoleById(-3));
    }

    // Now, how do we go about testing for positive values?
    // We need fake a call to the roleDAO and essentially return it with a return value

    @Test
    public void getRoleByIdPositiveInt(){
        // Let's create a fake Role object we want to return from the db
        Role role = new Role(4, "Supreme Leader Of The World", 1000000);

        // Now we need to make sure our dao returns this when called
        when(mockRoleDao.getRoleById(4)).thenReturn(role);

        assertEquals(role, roleService.getRoleById(4));
    }

    // Let's test the update salary method
    @Test
    public void updateRoleSalaryNullTitle(){
        String title = null;

        assertFalse(roleService.updateSalary(12345, title));

        // We need to make this test "stronger"
        // Let's also verify that our method for updating the db was NOT called
        verifyNoInteractions(mockRoleDao);
    }

    @Test
    public void updateRoleSalaryBlankTitleString(){
        String title = "    ";

        assertFalse(roleService.updateSalary(12345, title));

        // We need to make this test "stronger"
        // Let's also verify that our method for updating the db was NOT called
        verifyNoInteractions(mockRoleDao);
    }

    // Let's test this with a title that is formatted incorrectly
    @Test
    public void updateSalaryMalformedTitle(){
        String title = "fRY cOOk"; // WANT this to turn in "Fry Cook"

        // Fixed this to have anyInt and anyString
        when(mockRoleDao.updateRoleSalary(anyInt(), anyString())).thenReturn(true);

        roleService.updateSalary(12345, title);

        // Used Mockito.eq to fix this mistake
        verify(mockRoleDao, times(1)).updateRoleSalary(eq(12345), eq("Fry Cook"));

    }

}
