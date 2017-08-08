package org.jon.lv.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: plotVO  如果要取出来用就store，只查询就不用store
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/8/7 10:39
 * version V1.0.0
 */
@Document(indexName = "dongtong_global", type="plots")
public class PlotVO implements Serializable {
    @Id
    private Long id;

    /**
     * 估价宝小区id
     */
    @Field(type = FieldType.Long, store = true)
    private Long residenceId;

    /**
     * 小区所在城市
     */
    @Field(type = FieldType.Long, store = false)
    private Long cityId;

    /**
     * 板块id
     */
    @Field(type = FieldType.Long, store = true)
    private Long blockId;

    /**
     * 板块名称
     */
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String blockName;

    /**
     * 区域id
     */
    @Field(type = FieldType.Long, store = true)
    private Long districtId;

    /**
     * 区域名称
     */
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String districtName;

    /**
     * 小区名称
     */
    @Field(type = FieldType.String, analyzer="ik", searchAnalyzer="ik", store = true)
    private String plotName;

    /**
     * 小区别名
     */
    @Field(type = FieldType.String, analyzer="ik", searchAnalyzer="ik", store = false)
    private String plotAlias;

    /**
     * 小区名称全拼
     */
    @Field(type = FieldType.String, analyzer="ik", searchAnalyzer="ik", store = false)
    private String plotPinyin;

    /**
     * 小区名称拼音缩写
     */
    @Field(type = FieldType.String, analyzer="ik", searchAnalyzer="ik", store = false)
    private String plotPinyinAbbr;

    /**
     * 小区地址
     */
    @Field(type = FieldType.String, analyzer="ik", searchAnalyzer="ik", store = true)
    private String plotAddress;

    /**
     * 小区邮编
     */
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = false)
    private String plotPostcode;

    /**
     * 小区X坐标
     */
    @Field(type = FieldType.Double, index = FieldIndex.not_analyzed, store = true)
    private String longtitude;

    /**
     * 小区Y坐标
     */
    @Field(type = FieldType.Double, index = FieldIndex.not_analyzed, store = true)
    private String latitude;

    /**
     * 小区类别（1老公房[一般住宅] 2公寓[别墅+住宅]3别墅[纯别墅]4酒店式公寓[商住混合]5花园洋房 6其它）
     */
    @Field(type = FieldType.Integer, store = true)
    private Integer plotType;

    /**
     * 建筑类型
     */
    @Field(type = FieldType.Integer, store = false)
    private Integer plotBuildType;

    /**
     * 建造年份
     */
    @Field(type = FieldType.Integer, store = true)
    private Integer plotBuildYear;

    /**
     * 总占地面积
     */
    @Field(type = FieldType.Double, store = true)
    private BigDecimal plotLandArea;

    /**
     * 总建筑面积
     */
    @Field(type = FieldType.Double, store = true)
    private BigDecimal plotBuildArea;

    /**
     * 容积率
     */
    @Field(type = FieldType.Double, store = true)
    private BigDecimal plotVolumeRatio;

    /**
     * 绿化率
     */
    @Field(type = FieldType.Double, store = true)
    private BigDecimal plotGreenRatio;

    /**
     * 平均得房率
     */
    @Field(type = FieldType.Double, store = true)
    private BigDecimal plotConstructionRatio;

    /**
     * 楼栋数
     */
    @Field(type = FieldType.Integer, store = true)
    private Short buildingCount;

    /**
     * 总户数
     */
    @Field(type = FieldType.Integer, store = true)
    private Integer houseCount;

    /**
     * 车位总数
     */
    @Field(type = FieldType.Integer, store = true)
    private Integer groundParkingCount;

    /**
     * 固定车位
     */
    @Field(type = FieldType.Integer, store = true)
    private Integer undergroundParkingCount;

    /**
     * 物业费
     */
    @Field(type = FieldType.Double, store = true)
    private BigDecimal propertyFee;

    /**
     * 封面图编号
     */
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String plotCoverPicUrl;

    /**
     * 小区状态 0-正常 9-禁用
     */
    @Field(type = FieldType.Integer, store = false)
    private Integer plotStatus;

    /**
     * 小区均价
     */
    @Field(type = FieldType.Integer, index = FieldIndex.not_analyzed, store = false)
    private Integer averagePrice;

    /**
     * 优惠信息
     */
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = false)
    private String plotDiscountInfo;

    /**
     * 供暖方式
     */
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = false)
    private String heatMethod;

    /**
     * 开发商id
     */
    @Field(type = FieldType.Long, store = false)
    private Long developerId;

    /**
     * 开发商名称
     */
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = false)
    private String developerName;

    /**
     * 产权年限
     */
    @Field(type = FieldType.Integer, store = false)
    private Integer propertyRight;

    /**
     * 环线位置
     */
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = false)
    private String loopLocation;

    /**
     * 交工日期
     */
    @Field( type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss", store = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date completeDate;

    /**
     * 物业公司
     */
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = false)
    private String businessCompany;

    /**
     * 相关学校
     */
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = false)
    private String nearbySchool;

    /**
     * 数据创建人id
     */
    @Field(type = FieldType.Long, store = true)
    private Long creator;

    /**
     * 创建时间
     */
    @Field( type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss", store = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改人
     */
    @Field(type = FieldType.Long, store = true)
    private Long modifier;

    /**
     * 修改时间
     */
    @Field( type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss", store = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     * 地理位置经纬度
     * lat纬度，lon经度 "40.715,-74.011"
     */
    @GeoPointField
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(Long residenceId) {
        this.residenceId = residenceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getPlotAlias() {
        return plotAlias;
    }

    public void setPlotAlias(String plotAlias) {
        this.plotAlias = plotAlias;
    }

    public String getPlotPinyin() {
        return plotPinyin;
    }

    public void setPlotPinyin(String plotPinyin) {
        this.plotPinyin = plotPinyin;
    }

    public String getPlotPinyinAbbr() {
        return plotPinyinAbbr;
    }

    public void setPlotPinyinAbbr(String plotPinyinAbbr) {
        this.plotPinyinAbbr = plotPinyinAbbr;
    }

    public String getPlotAddress() {
        return plotAddress;
    }

    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress;
    }

    public String getPlotPostcode() {
        return plotPostcode;
    }

    public void setPlotPostcode(String plotPostcode) {
        this.plotPostcode = plotPostcode;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getPlotType() {
        return plotType;
    }

    public void setPlotType(Integer plotType) {
        this.plotType = plotType;
    }

    public Integer getPlotBuildType() {
        return plotBuildType;
    }

    public void setPlotBuildType(Integer plotBuildType) {
        this.plotBuildType = plotBuildType;
    }

    public Integer getPlotBuildYear() {
        return plotBuildYear;
    }

    public void setPlotBuildYear(Integer plotBuildYear) {
        this.plotBuildYear = plotBuildYear;
    }

    public BigDecimal getPlotLandArea() {
        return plotLandArea;
    }

    public void setPlotLandArea(BigDecimal plotLandArea) {
        this.plotLandArea = plotLandArea;
    }

    public BigDecimal getPlotBuildArea() {
        return plotBuildArea;
    }

    public void setPlotBuildArea(BigDecimal plotBuildArea) {
        this.plotBuildArea = plotBuildArea;
    }

    public BigDecimal getPlotVolumeRatio() {
        return plotVolumeRatio;
    }

    public void setPlotVolumeRatio(BigDecimal plotVolumeRatio) {
        this.plotVolumeRatio = plotVolumeRatio;
    }

    public BigDecimal getPlotGreenRatio() {
        return plotGreenRatio;
    }

    public void setPlotGreenRatio(BigDecimal plotGreenRatio) {
        this.plotGreenRatio = plotGreenRatio;
    }

    public BigDecimal getPlotConstructionRatio() {
        return plotConstructionRatio;
    }

    public void setPlotConstructionRatio(BigDecimal plotConstructionRatio) {
        this.plotConstructionRatio = plotConstructionRatio;
    }

    public Short getBuildingCount() {
        return buildingCount;
    }

    public void setBuildingCount(Short buildingCount) {
        this.buildingCount = buildingCount;
    }

    public Integer getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(Integer houseCount) {
        this.houseCount = houseCount;
    }

    public Integer getGroundParkingCount() {
        return groundParkingCount;
    }

    public void setGroundParkingCount(Integer groundParkingCount) {
        this.groundParkingCount = groundParkingCount;
    }

    public Integer getUndergroundParkingCount() {
        return undergroundParkingCount;
    }

    public void setUndergroundParkingCount(Integer undergroundParkingCount) {
        this.undergroundParkingCount = undergroundParkingCount;
    }

    public BigDecimal getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(BigDecimal propertyFee) {
        this.propertyFee = propertyFee;
    }

    public String getPlotCoverPicUrl() {
        return plotCoverPicUrl;
    }

    public void setPlotCoverPicUrl(String plotCoverPicUrl) {
        this.plotCoverPicUrl = plotCoverPicUrl;
    }

    public Integer getPlotStatus() {
        return plotStatus;
    }

    public void setPlotStatus(Integer plotStatus) {
        this.plotStatus = plotStatus;
    }

    public Integer getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Integer averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getPlotDiscountInfo() {
        return plotDiscountInfo;
    }

    public void setPlotDiscountInfo(String plotDiscountInfo) {
        this.plotDiscountInfo = plotDiscountInfo;
    }

    public String getHeatMethod() {
        return heatMethod;
    }

    public void setHeatMethod(String heatMethod) {
        this.heatMethod = heatMethod;
    }

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Integer getPropertyRight() {
        return propertyRight;
    }

    public void setPropertyRight(Integer propertyRight) {
        this.propertyRight = propertyRight;
    }

    public String getLoopLocation() {
        return loopLocation;
    }

    public void setLoopLocation(String loopLocation) {
        this.loopLocation = loopLocation;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public String getBusinessCompany() {
        return businessCompany;
    }

    public void setBusinessCompany(String businessCompany) {
        this.businessCompany = businessCompany;
    }

    public String getNearbySchool() {
        return nearbySchool;
    }

    public void setNearbySchool(String nearbySchool) {
        this.nearbySchool = nearbySchool;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getLocation() {
//        location = FormatUtils.formatLocation(this.latitude, this.longtitude);
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
