package com.netcracker.services.Implementations;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.netcracker.model.Computer;
import com.netcracker.model.Office;
import com.netcracker.mongo.MongoFactory;
import com.netcracker.services.Interfaces.OfficeService;
import org.bson.types.ObjectId;

import java.util.LinkedList;

public class OfficeServiceImp implements OfficeService {
    static String dbName = "mydb", dbCollection = "mycollection";

    @Override
    public Office getOfficeById(ObjectId id) {
        DBCollection collection = MongoFactory.getCollection(dbName, dbCollection);
        return (Office) collection.findOne(id);
    }

    @Override
    public LinkedList<Office> getAllOffices() {
        LinkedList<Office> officeList = new LinkedList<Office>();
        DBCollection collection = MongoFactory.getCollection(dbName, dbCollection);
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            DBObject dbObject = cursor.next();
            Office office = new Office();
            office.setName(dbObject.get("name").toString());
            office.setId((ObjectId) dbObject.get("id"));
            office.setCountOfEmployee((Integer) dbObject.get("countOfEmployee"));
            office.setComputerList((LinkedList<Computer>) dbObject.get("computerList"));
            officeList.add(office);
        }
        return officeList;
    }

    @Override
    public void addIOffice(Office office) {

    }

    @Override
    public void editCountOfEmployee(Office office) {

    }

    @Override
    public void editName(Office office) {

    }

    @Override
    public void addComputer(Office office) {

    }

    @Override
    public void deleteOffice(Office office) {

    }
}
