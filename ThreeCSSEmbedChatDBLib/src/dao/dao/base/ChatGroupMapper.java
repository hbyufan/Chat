package dao.dao.base;

import dao.model.base.ChatGroup;
import dao.model.base.ChatGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    long countByExample(ChatGroupCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    int deleteByExample(ChatGroupCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String chatGroupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    int insert(ChatGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    int insertSelective(ChatGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    List<ChatGroup> selectByExample(ChatGroupCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    ChatGroup selectByPrimaryKey(String chatGroupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ChatGroup record, @Param("example") ChatGroupCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ChatGroup record, @Param("example") ChatGroupCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ChatGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ChatGroup record);
}