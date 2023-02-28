package com.coursemanagement.admin.manage;

public interface ManageModelControllerCallBack {
    void courseAddedResult(String course_added_successfully);

    void removeCourseResult(String course_was_deleted_successfully);
}
