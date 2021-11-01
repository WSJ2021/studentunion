package com.student.union.service;

import com.student.union.entity.Meeting;

import java.util.List;

public interface IMeetingService {
    /**
     * 添加会议记录
     */
    void addMeeting(Meeting meeting);
    /**
     * 根据会议id删除会议记录
     */
    void delMeeting(String meetingId);

    /**
     * 根据会议id修改会议记录
     */
    void upMeeting(Meeting meeting);
    /**
     * 查询所有会议记录
     */
    List<Meeting> getMeeting(String meetingCapital);
    /**
     * 根据会议时间搜索会议记录
     */
    List<Meeting> getMeetingBytime(String meetingTime);
    /**
     * 根据会议名称模糊搜索会议记录
     */
    List<Meeting> getMeetingBytitle(String meetingTitle);
}
