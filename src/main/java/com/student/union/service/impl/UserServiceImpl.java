package com.student.union.service.impl;

import com.student.union.dao.IUserDao;
import com.student.union.entity.User;
import com.student.union.service.IUserService;
import com.student.union.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao iuserDao;
    /**
     * 注册
     */
   public void addUser (User user){
       iuserDao.addUser(user);
    }
    /**
     * 登录
     */
   public User login(User user){
        User user1=new User();
        User user2=iuserDao.login(user);
        user1.setUserId(StringUtil.valueOf(user2.getUserId()));
        user1.setUserName(StringUtil.valueOf(user2.getUserName()));
        user1.setPassword(StringUtil.valueOf(user2.getPassword()));
        user1.setGrade(StringUtil.valueOf(user2.getGrade()));
        user1.setPhone(StringUtil.valueOf(user2.getPhone()));
        user1.setPosition(StringUtil.valueOf(user2.getPosition()));
        user1.setPosiId(StringUtil.valueOf(user2.getPosiId()));
        user1.setSex(StringUtil.valueOf(user2.getSex()));
        user1.setUserState(StringUtil.valueOf(user2.getUserState()));
        user1.setDepartValue(StringUtil.valueOf(user2.getDepartValue()));
        return  user1;
    }
    /**
     * 按部门查询人员
     */
    @Override
    public List<User> userByDepart(String departValue) {
        List<User> users=iuserDao.userByDepart(departValue);
        return users;
    }
    /**
     * 部长查询本部门人员
     */
    @Override
    public List<User> getUserDepart(String departValue) {
            return iuserDao.getUserDepart(departValue);}
    /**
     * 更改用户状态
     */
    @Override
    public void isnUser(String userId, String userState) {
        iuserDao.isnUser(userId,userState);
    }
    /**
     * 根据用户id查用户
     */
    @Override
    public User getUserById(String userId) {
        return iuserDao.getUserById(userId);
    }
    /**
     * 根据用户修改用户信息
     */
    @Override
    public void upUserInfo(User user) {
        iuserDao.upUserInfo(user);
    }
    /**
     * 上传头像
     */
    @Override
    public void addPhotoPath(String photoPath,String userId) {
        iuserDao.addPhotoPath(photoPath,userId);
    }
    /**
     * 根据用户id删用户
     */
    @Override
    public void delUserById(String userId) {
         iuserDao.delUserById(userId);
    }
    /**
     * 查询管理者
     */
    @Override
    public List<User> userCon() {
        return iuserDao.userCon();
    }
    /**
     * 赋予权限
     */
    @Override
    public void empower(String position, String userId) {
        iuserDao.empower(position,userId);
    }
    /**
     * 查询所有部长副部长
     */
    @Override
    public List<User> minister() {
        return iuserDao.minister();
    }
    /**
     * 管理员修改用户所有信息
     */
    @Override
    public void upUser(User user) {
       iuserDao.upUser(user);
    }


}
