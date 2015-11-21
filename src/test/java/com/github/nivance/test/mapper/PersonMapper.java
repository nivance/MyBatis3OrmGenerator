package com.github.nivance.test.mapper;

import com.github.nivance.test.entity.PersonExample;
import com.github.nivance.test.entity.PersonKey;
import com.github.nivance.test.entity.PersonWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PersonMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @SelectProvider(type=PersonSqlProvider.class, method="countByExample")
    int countByExample(PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @DeleteProvider(type=PersonSqlProvider.class, method="deleteByExample")
    int deleteByExample(PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @Delete({
        "delete from person",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(PersonKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @Insert({
        "insert into person (id, firstname, ",
        "surname)",
        "values (#{id,jdbcType=INTEGER}, #{firstname,jdbcType=LONGVARCHAR}, ",
        "#{surname,jdbcType=LONGVARCHAR})"
    })
    int insert(PersonWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @InsertProvider(type=PersonSqlProvider.class, method="insertSelective")
    int insertSelective(PersonWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @SelectProvider(type=PersonSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="firstname", property="firstname", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="surname", property="surname", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<PersonWithBLOBs> selectByExampleWithBLOBs(PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @SelectProvider(type=PersonSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<PersonKey> selectByExample(PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @Select({
        "select",
        "id, firstname, surname",
        "from person",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="firstname", property="firstname", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="surname", property="surname", jdbcType=JdbcType.LONGVARCHAR)
    })
    PersonWithBLOBs selectByPrimaryKey(PersonKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @UpdateProvider(type=PersonSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PersonWithBLOBs record, @Param("example") PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @UpdateProvider(type=PersonSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") PersonWithBLOBs record, @Param("example") PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @UpdateProvider(type=PersonSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PersonKey record, @Param("example") PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @UpdateProvider(type=PersonSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PersonWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbggenerated Sat Nov 21 10:14:39 CST 2015
     */
    @Update({
        "update person",
        "set firstname = #{firstname,jdbcType=LONGVARCHAR},",
          "surname = #{surname,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(PersonWithBLOBs record);
}