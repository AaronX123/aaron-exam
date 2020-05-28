package aaron.exam.service.common.exception;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-04-24
 */
public enum  ExamError {
    PAPER_IS_PUBLISHED("070001","已经发布二维码，无法删除"),
    QUERY_ERROR("070002","查询失败"),
    SAVE_USER_ERROR("070003","保存考生失败"),
    DATA_NOT_EXIST("070004","考生未作答"),
    EXAM_RECORD_NOT_EXIST("070005","无此考试记录");
    ;
    String code;
    String msg;

    ExamError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
