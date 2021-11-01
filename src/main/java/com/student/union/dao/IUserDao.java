package com.student.union.dao;

import com.student.union.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDao {
    /**
     * 注册
     */
    void addUser (User user);
    /**
     * 登录
     */
    User login(User user);
    /**
     * 按部门查询人员(展示用)
     */
    List<User> userByDepart(String departValue);
    /**
     * 查询管理者
     */
    List<User> userCon();
    /**
     * 查询所有部长副部长
     */
    List<User> minister();
    /**
     * 部长查询本部门人员（禁用启用人员用）
     */
    List<User> getUserDepart(String departValue);
    /**
     * 改变账号状态
     */
    void isnUser(String userId,String userState);
    /**
     * 根据用户id查用户
     */
    User getUserById(String userId);
    /**
     * 根据用户修改用户信息
     */
    void upUserInfo(User user);
    /**
     * 管理员修改用户所有信息
     */
    void upUser(User user);
    /**
     * 上传头像
     */
    void addPhotoPath(String photoPath,String userId);
    /**
     * 根据用户id删用户
     */
    void delUserById(String userId);
    /**
     * 赋予权限
     */
    void empower(String position,String userId);
    /**
     * 查询身份表
     */

}
