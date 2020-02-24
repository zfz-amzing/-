package com.zfz.xiaomi.dao;

import com.zfz.xiaomi.entry.Consumer;
import com.zfz.xiaomi.entry.ConsumerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsumerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    long countByExample(ConsumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    int deleteByExample(ConsumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    int insert(Consumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    int insertSelective(Consumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    List<Consumer> selectByExample(ConsumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    Consumer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    int updateByExampleSelective(@Param("record") Consumer record, @Param("example") ConsumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    int updateByExample(@Param("record") Consumer record, @Param("example") ConsumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    int updateByPrimaryKeySelective(Consumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbg.generated Sun Feb 23 17:50:08 CST 2020
     */
    int updateByPrimaryKey(Consumer record);
}