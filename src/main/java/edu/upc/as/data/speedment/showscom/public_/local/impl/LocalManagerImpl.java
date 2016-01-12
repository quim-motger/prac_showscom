package edu.upc.as.data.speedment.showscom.public_.local.impl;

import com.speedment.Speedment;
import com.speedment.config.Column;
import com.speedment.config.Table;
import com.speedment.config.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;
import com.speedment.internal.core.config.mapper.identity.StringIdentityMapper;
import com.speedment.internal.core.manager.sql.AbstractSqlManager;
import edu.upc.as.data.speedment.showscom.public_.local.Local;

import javax.annotation.Generated;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the com.speedment.internal.ui.config.TableProperty@2c42abda.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class LocalManagerImpl extends AbstractSqlManager<Local> {
    
    private final TypeMapper<String, String> nomTypeMapper = new StringIdentityMapper();
    private final TypeMapper<String, String> adreATypeMapper = new StringIdentityMapper();
    
    public LocalManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<Local> getEntityClass() {
        return Local.class;
    }
    
    @Override
    public Object get(Local entity, Column column) {
        switch (column.getName()) {
            case "nom" : return entity.getNom();
            case "adreça" : return entity.getAdreA();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(Local entity, Column column, Object value) {
        switch (column.getName()) {
            case "nom" : entity.setNom((String) value); break;
            case "adreça" : entity.setAdreA((String) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("showscom.public.local");
    }
    
    protected Local defaultReadEntity(ResultSet resultSet) {
        final Local entity = newInstance();
        try {
            entity.setNom(nomTypeMapper.toJavaType(resultSet.getString(1)));
            entity.setAdreA(adreATypeMapper.toJavaType(resultSet.getString(2)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public Local newInstance() {
        return new LocalImpl(speedment);
    }
    
    @Override
    public String primaryKeyFor(Local entity) {
        return entity.getNom();
    }
}