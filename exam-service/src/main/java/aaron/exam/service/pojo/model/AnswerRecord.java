package aaron.exam.service.pojo.model;

import javax.persistence.*;

@Table(name = "answer_record")
public class AnswerRecord {
    /**
     * 答卷明细ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 我的答案
     */
    @Column(name = "my_answer")
    private String myAnswer;

    /**
     * 标准答案
     */
    @Column(name = "standard_answer")
    private String standardAnswer;

    /**
     * 得分
     */
    private Double score;

    /**
     * 评价
     */
    private String evaluate;

    /**
     * 题目ID
     */
    @Column(name = "paper_subject_id")
    private Long paperSubjectId;

    @Column(name = "exam_record_id")
    private Long examRecordId;

    /**
     * 获取答卷明细ID
     *
     * @return id - 答卷明细ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置答卷明细ID
     *
     * @param id 答卷明细ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取我的答案
     *
     * @return my_answer - 我的答案
     */
    public String getMyAnswer() {
        return myAnswer;
    }

    /**
     * 设置我的答案
     *
     * @param myAnswer 我的答案
     */
    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }

    /**
     * 获取标准答案
     *
     * @return standard_answer - 标准答案
     */
    public String getStandardAnswer() {
        return standardAnswer;
    }

    /**
     * 设置标准答案
     *
     * @param standardAnswer 标准答案
     */
    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }

    /**
     * 获取得分
     *
     * @return score - 得分
     */
    public Double getScore() {
        return score;
    }

    /**
     * 设置得分
     *
     * @param score 得分
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * 获取评价
     *
     * @return evaluate - 评价
     */
    public String getEvaluate() {
        return evaluate;
    }

    /**
     * 设置评价
     *
     * @param evaluate 评价
     */
    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    /**
     * 获取题目ID
     *
     * @return paper_subject_id - 题目ID
     */
    public Long getPaperSubjectId() {
        return paperSubjectId;
    }

    /**
     * 设置题目ID
     *
     * @param paperSubjectId 题目ID
     */
    public void setPaperSubjectId(Long paperSubjectId) {
        this.paperSubjectId = paperSubjectId;
    }

    /**
     * @return exam_record_id
     */
    public Long getExamRecordId() {
        return examRecordId;
    }

    /**
     * @param examRecordId
     */
    public void setExamRecordId(Long examRecordId) {
        this.examRecordId = examRecordId;
    }
}