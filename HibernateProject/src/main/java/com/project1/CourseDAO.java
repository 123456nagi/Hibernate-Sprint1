// CourseDAO.java
package com.project1;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CourseDAO {
    
    private EntityManager em;

    public CourseDAO(EntityManager em) {
        this.em = em;
    }

    public void createCourse(Course course) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();

            if (!tx.isActive()) {
                tx.begin();
            }

            Course mergedCourse = em.merge(course);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(int id, String newCourseName, double newCourseFee) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();

            if (!tx.isActive()) {
                tx.begin();
            }

            Course course = em.find(Course.class, id);
            if (course != null) {
                course.setCourseName(newCourseName);
                course.setCourseFee(newCourseFee);

                em.merge(course);
                tx.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<Course> getCourseById(int id) {
        Course course = em.find(Course.class, id);

        if (course != null) {
            return Optional.of(course);
        } else {
            return Optional.empty();
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses = em.createQuery("from Course", Course.class).getResultList();
        return courses;
    }

    public void removeCourseById(int id) {
        EntityTransaction tx = null;

        Course course = em.find(Course.class, id);

        try {
            tx = em.getTransaction();

            if (!tx.isActive()) {
                tx.begin();
            }

            em.remove(course);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

