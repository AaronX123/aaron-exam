package aaron.exam.service.pojo.VO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-05
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdAndName {
    @JsonSerialize(using = ToStringSerializer.class)
    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IdAndName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
