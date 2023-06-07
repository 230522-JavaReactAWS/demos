import com.revature.daos.RoleDAO;
import com.revature.models.Role;
import com.revature.service.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RoleServiceTest {

    // We're mocking the DAO to prevent calls to the actual DB
    RoleDAO mockRoleDao = Mockito.mock(RoleDAO.class);
    RoleService roleService = new RoleService(mockRoleDao);

    @Test
    public void getRoleByIdZero(){
        // What should we get when we pass zero to this method?
        // Zero shouldn't pass the if condition, so we should be able to just verify null

        Assertions.assertNull(roleService.getRoleById(0));
    }

    @Test
    public void getRoleByIdNegativeInt(){
        // What should we get when we pass zero to this method?
        // Zero shouldn't pass the if condition, so we should be able to just verify null

        Assertions.assertNull(roleService.getRoleById(-3));
    }

    // Now, how do we go about testing for positive values?
    // We need fake a call to the roleDAO and essentially return it with a return value

    @Test
    public void getRoleByIdPositiveInt(){
        // Let's create a fake Role object we want to return from the db
        Role role = new Role(4, "Supreme Leader Of The World", 1000000);

        // Now we need to make sure our dao returns this when called
        Mockito.when(mockRoleDao.getRoleById(4)).thenReturn(role);

        Assertions.assertEquals(role, roleService.getRoleById(4));
    }

    // Let's test the update salary method
    @Test
    public void updateRoleSalaryNullTitle(){
        String title = null;

        Assertions.assertFalse(roleService.updateSalary(12345, title));

        // We need to make this test "stronger"
        // Let's also verify that our method for updating the db was NOT called
        Mockito.verifyNoInteractions(mockRoleDao);
    }

    @Test
    public void updateRoleSalaryBlankTitleString(){
        String title = "    ";

        Assertions.assertFalse(roleService.updateSalary(12345, title));

        // We need to make this test "stronger"
        // Let's also verify that our method for updating the db was NOT called
        Mockito.verifyNoInteractions(mockRoleDao);
    }

    // Let's test this with a title that is formatted incorrectly
    // TODO Fix this test
    @Test
    public void updateSalaryMalformedTitle(){
        String title = "fRY cOOk";

        Mockito.when(mockRoleDao.updateRoleSalary(Mockito.any(), Mockito.any())).thenReturn(true);

        roleService.updateSalary(12345, title);

        Mockito.verify(mockRoleDao, Mockito.times(1)).updateRoleSalary(12345, "Fry Cook");
    }


}
