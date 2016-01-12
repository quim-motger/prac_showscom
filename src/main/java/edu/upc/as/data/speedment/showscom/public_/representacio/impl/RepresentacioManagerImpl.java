package edu.upc.as.data.speedment.showscom.public_.representacio.impl;

import com.speedment.Speedment;
import com.speedment.config.Column;
import com.speedment.config.Table;
import com.speedment.config.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;
import com.speedment.internal.core.config.mapper.identity.DateIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.FloatIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.StringIdentityMapper;
import com.speedment.internal.core.manager.sql.AbstractSqlManager;
import edu.upc.as.data.speedment.showscom.public_.representacio.Representacio;

import javax.annotation.Generated;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the com.speedment.internal.ui.config.TableProperty@503b857e.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class RepresentacioManagerImpl extends AbstractSqlManager<Representacio> {
    
    private final TypeMapper<String, String> titolespectacleTypeMapper = new StringIdentityMapper();
    private final TypeMapper<String, String> sessioTypeMapper = new StringIdentityMapper();
    private final TypeMapper<String, String> nomlocalTypeMapper = new StringIdentityMapper();
    private final TypeMapper<Float, Float> preuTypeMapper = new FloatIdentityMapper();
    private final TypeMapper<Date, Date> dataTypeMapper = new DateIdentityMapper();
    private final TypeMapper<Integer, Integer> nombreseienslliuresTypeMapper = new IntegerIdentityMapper();
    
    public RepresentacioManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<Representacio> getEntityClass() {
        return Representacio.class;
    }
    
    @Override
    public Object get(Representacio entity, Column column) {
        switch (column.getName()) {
            case "titolespectacle" : return entity.getTitolespectacle();
            case "sessio" : return entity.getSessio();
            case "nomlocal" : return entity.getNomlocal();
            case "preu" : return entity.getPreu();
            case "data" : return entity.getData();
            case "nombreseienslliures" : return entity.getNombreseienslliures();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(Representacio entity, Column column, Object value) {
        switch (column.getName()) {
            case "titolespectacle" : entity.setTitolespectacle((String) value); break;
            case "sessio" : entity.setSessio((String) value); break;
            case "nomlocal" : entity.setNomlocal((String) value); break;
            case "preu" : entity.setPreu((Float) value); break;
            case "data" : entity.setData((Date) value); break;
            case "nombreseienslliures" : entity.setNombreseienslliures((Integer) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("showscom.public.representacio");
    }
    
    protected Representacio defaultReadEntity(ResultSet resultSet) {
        final Representacio entity = newInstance();
        try {
            entity.setTitolespectacle(titolespectacleTypeMapper.toJavaType(resultSet.getString(1)));
            entity.setSessio(sessioTypeMapper.toJavaType(resultSet.getString(2)));
            entity.setNomlocal(nomlocalTypeMapper.toJavaType(resultSet.getString(3)));
            entity.setPreu(preuTypeMapper.toJavaType(resultSet.getFloat(4)));
            entity.setData(dataTypeMapper.toJavaType(resultSet.getDate(5)));
            entity.setNombreseienslliures(nombreseienslliuresTypeMapper.toJavaType(resultSet.getInt(6)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public Representacio newInstance() {
        return new RepresentacioImpl(speedment);
    }
    
    @Override
    public List<String> primaryKeyFor(Representacio entity) {
        return Arrays.asList(entity.getSessio(), entity.getNomlocal());
    }
}