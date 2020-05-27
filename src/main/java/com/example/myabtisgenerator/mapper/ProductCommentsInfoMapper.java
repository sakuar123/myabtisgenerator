package com.example.myabtisgenerator.mapper;

import com.example.myabtisgenerator.entity.ProductCommentsInfo;
import com.example.myabtisgenerator.entity.ProductCommentsInfoExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProductCommentsInfoMapper {
    @SelectProvider(type=ProductCommentsInfoSqlProvider.class, method="countByExample")
    int countByExample(ProductCommentsInfoExample example);

    @DeleteProvider(type=ProductCommentsInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductCommentsInfoExample example);

    @Delete({
        "delete from product_comments_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product_comments_info (product_id, user_id, ",
        "comments_messsage, start_level, ",
        "create_time, update_time)",
        "values (#{productId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{commentsMesssage,jdbcType=VARCHAR}, #{startLevel,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(ProductCommentsInfo record);

    @InsertProvider(type=ProductCommentsInfoSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(ProductCommentsInfo record);

    @SelectProvider(type=ProductCommentsInfoSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="product_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="comments_messsage", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="start_level", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<ProductCommentsInfo> selectByExample(ProductCommentsInfoExample example);

    @Select({
        "select",
        "id, product_id, user_id, comments_messsage, start_level, create_time, update_time",
        "from product_comments_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="product_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="comments_messsage", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="start_level", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    ProductCommentsInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProductCommentsInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductCommentsInfo record, @Param("example") ProductCommentsInfoExample example);

    @UpdateProvider(type=ProductCommentsInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductCommentsInfo record, @Param("example") ProductCommentsInfoExample example);

    @UpdateProvider(type=ProductCommentsInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductCommentsInfo record);

    @Update({
        "update product_comments_info",
        "set product_id = #{productId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "comments_messsage = #{commentsMesssage,jdbcType=VARCHAR},",
          "start_level = #{startLevel,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductCommentsInfo record);
}