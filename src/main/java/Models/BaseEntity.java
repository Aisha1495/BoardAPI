package Models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.sql.Date;

@MappedSuperclass
@Getter
@Setter
@Data
public class BaseEntity {
    Date createdDate;
    Date updatedDate;
    Boolean isActive;
}
