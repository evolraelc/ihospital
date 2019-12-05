package entity;

import com.ihospital.pojo.Consultation;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 感觉好想睡觉
 * @date 2019/11/19 20:31
 * @description 评论条列
 * @project ihospital
 */
public class CommentItem implements Serializable {
    private Long consultId;
    private Long patientId;
    private String patientName;
    private Long physicianId;
    private String physicianName;
    private Date createTime;
    private String body;
    private Integer replyCount;

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getConsultId() {
        return consultId;
    }

    public void setConsultId(Long consultId) {
        this.consultId = consultId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Long getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Long physicianId) {
        this.physicianId = physicianId;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
