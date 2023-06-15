package com.revature.services;

import com.revature.daos.TeacherDAO;
import com.revature.exceptions.TeacherNotFoundException;
import com.revature.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    // First thing we need to do is inject in our teacher dao

    private final TeacherDAO teacherDao;

    @Autowired // We wired in
    public TeacherService(TeacherDAO teacherDao) {
        this.teacherDao = teacherDao;
    }


    // We can now start creating all of our service methods

    // Create
    public Teacher createTeacher(Teacher t){
        // Now let's call the DAO methods to actually create the teacher
        Teacher returnedTeacher = teacherDao.save(t);

        // If successful we should have a positive Id
        if (returnedTeacher.getId() > 0){
            // TODO create a log for success
        } else{
            // TODO create a log for failure
        }

        return returnedTeacher;
    }

    // Read All
    public List<Teacher> getAllTeachers(){
        return teacherDao.findAll();
    }

    // Read One
    public Teacher getTeacherById(int id){
        // We'll use the optional methods to return the proper thing
        return teacherDao.findById(id).orElseThrow(() -> new TeacherNotFoundException("No teacher found with id: " + id));
    }


    // Update
    public Teacher updateTeacher(Teacher t){
        return teacherDao.save(t);
    }

    // Delete
    public boolean deleteTeacherById(int id){
        // We need to delete by id then verify nonexistence
        teacherDao.deleteById(id);

        // We need to check to see if the teacher is still in the db
        if (!teacherDao.existsById(id)){
            // Successful message
            return true;
        } else{
            return false;
        }
    }
}
