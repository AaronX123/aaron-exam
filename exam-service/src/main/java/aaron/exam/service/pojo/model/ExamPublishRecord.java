package aaron.exam.service.pojo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "exam_publish_record")
public class ExamPublishRecord {
    /**
     * 考试发布记录ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 考试标题
     */
    private String title;

    /**
     * 考试场次
     */
    @Column(name = "exam_session")
    private Integer examSession;

    /**
     * 发布人
     */
    private Long publisher;

    /**
     * 考试开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 考试结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 计划人数
     */
    @Column(name = "plan_pepole_num")
    private Integer planPepoleNum;

    /**
     * 考试时长
     */
    @Column(name = "limit_time")
    private Integer limitTime;

    /**
     * 考试说明
     */
    private String descript;

    /**
     * 阅卷方式
     */
    @Column(name = "marking_mode")
    private Long markingMode;

    /**
     * 阅卷停止时间
     */
    @Column(name = "marking_stop_time")
    private Date markingStopTime;

    /**
     * 二维码链接
     */
    @Column(name = "qrcode_url")
    private String qrcodeUrl;

    /**
     * 状态位
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

    /**
     * 预留字段1
     */
    private String field1;

    /**
     * 预留字段2
     */
    private String field2;

    /**
     * 试卷ID
     */
    @Column(name = "paper_id")
    private Long paperId;

    /**
     * examRecords 关联
     */
    List<ExamRecord> examRecords;

    public List<ExamRecord> getExamRecords() {
        return examRecords;
    }

    public void setExamRecords(List<ExamRecord> examRecords) {
        this.examRecords = examRecords;
    }

    /**
     * 获取考试发布记录ID
     *
     * @return id - 考试发布记录ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置考试发布记录ID
     *
     * @param id 考试发布记录ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取考试标题
     *
     * @return title - 考试标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置考试标题
     *
     * @param title 考试标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取考试场次
     *
     * @return exam_session - 考试场次
     */
    public Integer getExamSession() {
        return examSession;
    }

    /**
     * 设置考试场次
     *
     * @param examSession 考试场次
     */
    public void setExamSession(Integer examSession) {
        this.examSession = examSession;
    }

    /**
     * 获取发布人
     *
     * @return publisher - 发布人
     */
    public Long getPublisher() {
        return publisher;
    }

    /**
     * 设置发布人
     *
     * @param publisher 发布人
     */
    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }

    /**
     * 获取考试开始时间
     *
     * @return start_time - 考试开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置考试开始时间
     *
     * @param startTime 考试开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取考试结束时间
     *
     * @return end_time - 考试结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置考试结束时间
     *
     * @param endTime 考试结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取计划人数
     *
     * @return plan_pepole_num - 计划人数
     */
    public Integer getPlanPepoleNum() {
        return planPepoleNum;
    }

    /**
     * 设置计划人数
     *
     * @param planPepoleNum 计划人数
     */
    public void setPlanPepoleNum(Integer planPepoleNum) {
        this.planPepoleNum = planPepoleNum;
    }

    /**
     * 获取考试时长
     *
     * @return limit_time - 考试时长
     */
    public Integer getLimitTime() {
        return limitTime;
    }

    /**
     * 设置考试时长
     *
     * @param limitTime 考试时长
     */
    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }

    /**
     * 获取考试说明
     *
     * @return descript - 考试说明
     */
    public String getDescript() {
        return descript;
    }

    /**
     * 设置考试说明
     *
     * @param descript 考试说明
     */
    public void setDescript(String descript) {
        this.descript = descript;
    }

    /**
     * 获取阅卷方式
     *
     * @return marking_mode - 阅卷方式
     */
    public Long getMarkingMode() {
        return markingMode;
    }

    /**
     * 设置阅卷方式
     *
     * @param markingMode 阅卷方式
     */
    public void setMarkingMode(Long markingMode) {
        this.markingMode = markingMode;
    }

    /**
     * 获取阅卷停止时间
     *
     * @return marking_stop_time - 阅卷停止时间
     */
    public Date getMarkingStopTime() {
        return markingStopTime;
    }

    /**
     * 设置阅卷停止时间
     *
     * @param markingStopTime 阅卷停止时间
     */
    public void setMarkingStopTime(Date markingStopTime) {
        this.markingStopTime = markingStopTime;
    }

    /**
     * 获取二维码链接
     *
     * @return qrcode_url - 二维码链接
     */
    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    /**
     * 设置二维码链接
     *
     * @param qrcodeUrl 二维码链接
     */
    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    /**
     * 获取状态位
     *
     * @return status - 状态位
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态位
     *
     * @param status 状态位
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
     * 获取预留字段1
     *
     * @return field1 - 预留字段1
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置预留字段1
     *
     * @param field1 预留字段1
     */
    public void setField1(String field1) {
        this.field1 = field1;
    }

    /**
     * 获取预留字段2
     *
     * @return field2 - 预留字段2
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置预留字段2
     *
     * @param field2 预留字段2
     */
    public void setField2(String field2) {
        this.field2 = field2;
    }

    /**
     * 获取试卷ID
     *
     * @return paper_id - 试卷ID
     */
    public Long getPaperId() {
        return paperId;
    }

    /**
     * 设置试卷ID
     *
     * @param paperId 试卷ID
     */
    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }
}