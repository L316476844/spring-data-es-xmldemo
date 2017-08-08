# spring-data-es-xmldemo

## spring-data-elasticsearch xml方式搜索服务搭建

### 注意事项
1、spring-data-elasticsearch 和sping 版本注意冲突  例子使用的elasticsearch2.4 spring4.3.8。
   如果你使用的是别的版本请根据spring-data-elasticsearch中spring-tx的版本来引入其它spring的版本。

2、GUAVA jar冲突问题 项目中严格注意其它jar包中guava与es依赖的guava冲突

3、字段索引问题使用 ：如果要取出来用就store，只查询就不用store

4、@Document 不支持驼峰命名 必须全部为小写

5、字符串类型建立索引添加注解 @Field(type = FieldType.String, analyzer="ik", searchAnalyzer="ik", store = true) analyzer是建立索引使用的分词，searchAnalyzer是查询时候使用的分词

6、@GeoPointField 地理坐标注解 在字段上类型是String经纬度顺序：lat纬度，lon经度 "40.715,-74.011"  字段类型为double[]数组或point则不可这么使用

7、时间字段索引@Field( type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss", store = true) 还需要配合
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") 一起使用。可参考PlotVO代码。
