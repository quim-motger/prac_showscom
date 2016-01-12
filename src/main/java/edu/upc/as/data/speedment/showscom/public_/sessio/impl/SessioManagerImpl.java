package edu.upc.as.data.speedment.showscom.public_.sessio.impl;

import com.speedment.Speedment;
import com.speedment.config.Column;
import com.speedment.config.Table;
import com.speedment.config.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;
import com.speedment.internal.core.config.mapper.identity.StringIdentityMapper;
import com.speedment.internal.core.manager.sql.AbstractSqlManager;
import edu.upc.as.data.speedment.showscom.public_.sessio.Sessio;

import javax.annotation.Generated;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the com.speedment.internal.ui.config.TableProperty@5eada0c6.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class SessioManagerImpl extends AbstractSqlManager<Sessio> {
    
    private final TypeMapper<String, String> sessioTypeMapper = new StringIdentityMapper();
    
    public SessioManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<Sessio> getEntityClass() {
        return Sessio.class;
    }
    
    @Override
    public Object get(Sessio entity, Column column) {
        switch (column.getName()) {
            case "sessio" : return entity.getSessio();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(Sessio entity, Column column, Object value) {
        switch (column.getName()) {
            case "sessio" : entity.setSessio((String) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("showscom.public.sessio");
    }
    
    protected Sessio defaultReadEntity(ResultSet resultSet) {
        final Sessio entity = newInstance();
        try {
            entity.setSessio(sessioTypeMapper.toJavaType(resultSet.getString(1)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public Sessio newInstance() {
        return new SessioImpl(speedment);
    }
    
    @Override
    public String primaryKeyFor(Sessio entity) {
        return entity.getSessio();
    }
}