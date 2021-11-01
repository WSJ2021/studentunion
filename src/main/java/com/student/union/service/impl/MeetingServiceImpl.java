package com.student.union.service.impl;

import com.student.union.dao.IMeetingDao;
import com.student.union.entity.Meeting;
import com.student.union.service.IMeetingService;
import com.student.union.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements IMeetingService {
    @Autowired
    IMeetingDao iMeetingDao;
    /**
     * 添加会议记录
     */
    @Override
    public void addMeeting(Meeting meeting) {
        iMeetingDao.addMeeting(meeting);
    }
    /**
     * 根据会议id删除会议记录
     */
    @Override
    public void delMeeting(String meetingId) {
        iMeetingDao.delMeeting(meetingId);
    }
    /**
     * 根据会议id修改会议记录
     */
    @Override
    public void upMeeting(Meeting meeting) {
        iMeetingDao.upMeeting(meeting);
    }


    /**
     * 查询所有会议记录
     */
    @Override
    public List<Meeting> getMeeting(String meetingCapital) {
        return iMeetingDao.getMeeting(meetingCapital);
    }
    /**
     * 根据会议时间搜索会议记录
     */
    @Override
    public List<Meeting> getMeetingBytime(String meetingTime) {
            return iMeetingDao.getMeetingBytime(meetingTime);
        }

    /**
     * 根据会议标题模糊搜索会议记录
     */
    @Override
    public List<Meeting> getMeetingBytitle(String meetingTitle) {
        return iMeetingDao.getMeetingBytitle(meetingTitle);
    }

}
