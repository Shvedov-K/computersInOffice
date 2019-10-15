package com.netcracker.model;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Data
@ToString
public class Office {
    @Id
    private ObjectId id;

    @NotNull
    @Length(min = 1, max = 20)
    private String name;
    @NotNull
    @Min(0)
    private int countOfEmployee;
    private List<Computer> computerList = new LinkedList<>();

    public String getId() {
        return id.toHexString();
    }

    public ObjectId copyId() {
        return id;
    }
}
