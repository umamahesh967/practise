package com.database.jpa.hibernate.demo.entity;

/**
 *
 *
 * class Course
 * {
 *     courseId;
 *
 *     @OneToMany
 *     List<Review> reviews;
 * }
 *
 * class Review
 * {
 *     reviewId;
 *
 *     @ManyToOne
 *     Course course; //Here it contains object
 * }
 *
 * Tables
 *
 * @COURSE
 * Course_Id
 *
 * @REVIEW
 * REVIEW_ID;
 * COURSE_ID;
 *
 *
 * class PathSet
 * {
 *     pk,
 *
 *     pathSetId,
 *
 *     @OneToMany
 *     @JoinColumns({
 *             @JoinColumn(name = "PATH_SET_PK", referencedColumnName = "PK")
 *     })
 *     List<Path>
 * }
 *
 * class Path
 * {
 *     pk,
 *     @AttributeOverrides({
 *             @AttributeOverride(name = "pk", column = @Column(name = "PATH_SET_PK"))
 *     })
 *     int pathSetPk;
 *     pathId
 * }
 *
 * Tables
 *
 * @PATH_SET
 * PK
 * PATH_SET_ID
 *
 * @PATH
 * PK,
 * PATH_SET_PK,
 * PATH_SET_ID;
 *
 */
public class ERRelations {
}
