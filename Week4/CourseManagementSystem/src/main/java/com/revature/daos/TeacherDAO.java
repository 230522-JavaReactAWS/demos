package com.revature.daos;

import com.revature.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDAO extends JpaRepository<Teacher, Integer> {
}
