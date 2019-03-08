package self.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 成果数据实体类
 *
 * @author 123
 * @version 1.0, 2014-5-9
 */
@Data
public class ResultData {
    /**
     * 成果数据id
     */
    @Id
    @Column(name = "result_data_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultDataId;
    /**
     * 线路名称
     */
    private String lineName;
    /**
     * 杆塔号
     */
    private String startTowerName;
    /**
     * 杆塔号
     */
    private String endTowerName;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 作业时间
     */
    private String fileDate;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 类型
     */
    private String type;
    /**
     * 上传时间
     */
    private String storeDate;
    /**
     * 存储路径
     */
    private String path;
    /**
     * 上传人员
     */
    private User uploadUser;

    /**
     * 备注
     */
    private String remark;

    public Long getResultDataId() {
        return resultDataId;
    }

    public void setResultDataId(Long resultDataId) {
        this.resultDataId = resultDataId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getStartTowerName() {
        return startTowerName;
    }

    public void setStartTowerName(String startTowerName) {
        this.startTowerName = startTowerName;
    }

    public String getEndTowerName() {
        return endTowerName;
    }

    public void setEndTowerName(String endTowerName) {
        this.endTowerName = endTowerName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(String storeDate) {
        this.storeDate = storeDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public User getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(User uploadUser) {
        this.uploadUser = uploadUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
