package aaron.exam.service.pojo.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "exam_record")
public class ExamRecord {
    /**
     * 考试记录ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 考试人员工号
     */
    @Column(name = "examiner_code")
    private String examinerCode;

    /**
     * 考试人员
     */
    private String examiner;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 用户属性
     */
    @Column(name = "user_attribute")
    private Byte userAttribute;

    /**
     * 计划开始时间
     */
    @Column(name = "plan_start_time")
    private Date planStartTime;

    /**
     * 计划结束时间
     */
    @Column(name = "plan_end_time")
    private Date planEndTime;

    /**
     * 实际开始时间
     */
    @Column(name = "actual_start_time")
    private Date actualStartTime;

    /**
     * 实际结束时间
     */
    @Column(name = "actual_end_time")
    private Date actualEndTime;

    /**
     * 客观题得分
     */
    @Column(name = "objective_subject_score")
    private Double objectiveSubjectScore;

    /**
     * 主观题得分
     */
    @Column(name = "subjectvie_subject_score")
    private Double subjectvieSubjectScore;

    /**
     * 总分
     */
    private Double score;

    /**
     * 系统评价
     */
    @Column(name = "system_evaluate")
    private String systemEvaluate;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 修改人
     */
    @Column(name = "updated_by")
    private Long updatedBy;

    /**
     * 修改时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 版本
     */
    private Long version;

    @Column(name = "exam_publish_record_id")
    private Long examPublishRecordId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 获取考试记录ID
     *
     * @return id - 考试记录ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置考试记录ID
     *
     * @param id 考试记录ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取考试人员工号
     *
     * @return examiner_code - 考试人员工号
     */
    public String getExaminerCode() {
        return examinerCode;
    }

    /**
     * 设置考试人员工号
     *
     * @param examinerCode 考试人员工号
     */
    public void setExaminerCode(String examinerCode) {
        this.examinerCode = examinerCode;
    }

    /**
     * 获取考试人员
     *
     * @return examiner - 考试人员
     */
    public String getExaminer() {
        return examiner;
    }

    /**
     * 设置考试人员
     *
     * @param examiner 考试人员
     */
    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    /**
     * 获取手机号
     *
     * @return tel - 手机号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号
     *
     * @param tel 手机号
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取用户属性
     *
     * @return user_attribute - 用户属性
     */
    public Byte getUserAttribute() {
        return userAttribute;
    }

    /**
     * 设置用户属性
     *
     * @param userAttribute 用户属性
     */
    public void setUserAttribute(Byte userAttribute) {
        this.userAttribute = userAttribute;
    }

    /**
     * 获取计划开始时间
     *
     * @return plan_start_time - 计划开始时间
     */
    public Date getPlanStartTime() {
        return planStartTime;
    }

    /**
     * 设置计划开始时间
     *
     * @param planStartTime 计划开始时间
     */
    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    /**
     * 获取计划结束时间
     *
     * @return plan_end_time - 计划结束时间
     */
    public Date getPlanEndTime() {
        return planEndTime;
    }

    /**
     * 设置计划结束时间
     *
     * @param planEndTime 计划结束时间
     */
    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    /**
     * 获取实际开始时间
     *
     * @return actual_start_time - 实际开始时间
     */
    public Date getActualStartTime() {
        return actualStartTime;
    }

    /**
     * 设置实际开始时间
     *
     * @param actualStartTime 实际开始时间
     */
    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    /**
     * 获取实际结束时间
     *
     * @return actual_end_time - 实际结束时间
     */
    public Date getActualEndTime() {
        return actualEndTime;
    }

    /**
     * 设置实际结束时间
     *
     * @param actualEndTime 实际结束时间
     */
    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    /**
     * 获取客观题得分
     *
     * @return objective_subject_score - 客观题得分
     */
    public Double getObjectiveSubjectScore() {
        return objectiveSubjectScore;
    }

    /**
     * 设置客观题得分
     *
     * @param objectiveSubjectScore 客观题得分
     */
    public void setObjectiveSubjectScore(Double objectiveSubjectScore) {
        this.objectiveSubjectScore = objectiveSubjectScore;
    }

    /**
     * 获取主观题得分
     *
     * @return subjectvie_subject_score - 主观题得分
     */
    public Double getSubjectvieSubjectScore() {
        return subjectvieSubjectScore;
    }

    /**
     * 设置主观题得分
     *
     * @param subjectvieSubjectScore 主观题得分
     */
    public void setSubjectvieSubjectScore(Double subjectvieSubjectScore) {
        this.subjectvieSubjectScore = subjectvieSubjectScore;
    }

    /**
     * 获取总分
     *
     * @return score - 总分
     */
    public Double getScore() {
        return score;
    }

    /**
     * 设置总分
     *
     * @param score 总分
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * 获取系统评价
     *
     * @return system_evaluate - 系统评价
     */
    public String getSystemEvaluate() {
        return systemEvaluate;
    }

    /**
     * 设置系统评价
     *
     * @param systemEvaluate 系统评价
     */
    public void setSystemEvaluate(String systemEvaluate) {
        this.systemEvaluate = systemEvaluate;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取创建人
     *
     * @return created_by - 创建人
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取修改人
     *
     * @return updated_by - 修改人
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置修改人
     *
     * @param updatedBy 修改人
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取修改时间
     *
     * @return updated_time - 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置修改时间
     *
     * @param updatedTime 修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取版本
     *
     * @return version - 版本
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 设置版本
     *
     * @param version 版本
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return exam_publish_record_id
     */
    public Long getExamPublishRecordId() {
        return examPublishRecordId;
    }

    /**
     * @param examPublishRecordId
     */
    public void setExamPublishRecordId(Long examPublishRecordId) {
        this.examPublishRecordId = examPublishRecordId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}