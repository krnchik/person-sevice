package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContactMapper {

    @Select("select * from contact;")
    @Results(value = {
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "profileLink", column = "profile_link")
    })
    List<Contact> findAll();

    @Insert("insert into contact (phone_number, email, profile_link) values (#{phoneNumber}, #{email}, #{profileLink})")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    long save(Contact contact);
}
