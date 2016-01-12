import com.speedment.config.parameters.ColumnCompressionType
import com.speedment.config.parameters.FieldStorageType
import com.speedment.config.parameters.OrderType
import com.speedment.config.parameters.StorageEngineType

name = "speedment";
packageLocation = "src/main/java";
packageName = "edu.upc.as.data";
enabled = true;
expanded = true;
dbms {
    ipAddress = "127.0.0.1";
    name = "showscom";
    port = 5432;
    typeName = "PostgreSQL";
    username = "postgres";
    enabled = true;
    expanded = true;
    schema {
        columnCompressionType = ColumnCompressionType.NONE;
        fieldStorageType = FieldStorageType.WRAPPER;
        name = "public";
        schemaName = "public";
        storageEngineType = StorageEngineType.ON_HEAP;
        defaultSchema = false;
        enabled = true;
        expanded = true;
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "entrada";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "entrada";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "dniclient";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nombreespectadors";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.sql.Date.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "data";
                typeMapper = com.speedment.internal.core.config.mapper.identity.DateIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Float.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "preu";
                typeMapper = com.speedment.internal.core.config.mapper.identity.FloatIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "sessio";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nomlocal";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "identificador";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "identificador";
                enabled = true;
                expanded = true;
            }
            index {
                name = "entrada_pkey";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "identificador";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            foreignKey {
                name = "representacio_fkey";
                enabled = true;
                expanded = true;
                foreignKeyColumn {
                    foreignColumnName = "sessio";
                    foreignTableName = "representacio";
                    name = "sessio";
                    enabled = true;
                    expanded = true;
                }
                foreignKeyColumn {
                    foreignColumnName = "nomlocal";
                    foreignTableName = "representacio";
                    name = "nomlocal";
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "espectacle";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "espectacle";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "titol";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "participants";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "titol";
                enabled = true;
                expanded = true;
            }
            index {
                name = "espectacle_pkey";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "titol";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "estrena";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "estrena";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nomlocal";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "sessio";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "recarrec";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "nomlocal";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "sessio";
                enabled = true;
                expanded = true;
            }
            index {
                name = "estrena_pkey";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "nomlocal";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "sessio";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            foreignKey {
                name = "estrena_nomlocal_fkey";
                enabled = true;
                expanded = true;
                foreignKeyColumn {
                    foreignColumnName = "sessio";
                    foreignTableName = "representacio";
                    name = "nomlocal";
                    enabled = true;
                    expanded = true;
                }
                foreignKeyColumn {
                    foreignColumnName = "nomlocal";
                    foreignTableName = "representacio";
                    name = "sessio";
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "local";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "local";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nom";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "adreça";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "nom";
                enabled = true;
                expanded = true;
            }
            index {
                name = "local_pkey";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "nom";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "representacio";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "representacio";
            enabled = true;
            expanded = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "titolespectacle";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "sessio";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nomlocal";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Float.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "preu";
                typeMapper = com.speedment.internal.core.config.mapper.identity.FloatIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.sql.Date.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "data";
                typeMapper = com.speedment.internal.core.config.mapper.identity.DateIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nombreseienslliures";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "sessio";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "nomlocal";
                enabled = true;
                expanded = true;
            }
            index {
                name = "representacio_pkey";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "sessio";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "nomlocal";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            foreignKey {
                name = "representacio_titolespectacle_fkey";
                enabled = true;
                expanded = true;
                foreignKeyColumn {
                    foreignColumnName = "titol";
                    foreignTableName = "espectacle";
                    name = "titolespectacle";
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "seient";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "seient";
            enabled = true;
            expanded = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "fila";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "columna";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nomlocal";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "fila";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "columna";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "nomlocal";
                enabled = true;
                expanded = true;
            }
            index {
                name = "seient_pkey";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "fila";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "columna";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "nomlocal";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "seient_en_representacio";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "seient_en_representacio";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "sessio";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nomlocalrep";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nomlocal";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "fila";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "columna";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "estat";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "identificadorentrada";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "sessio";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "nomlocal";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "fila";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "columna";
                enabled = true;
                expanded = true;
            }
            index {
                name = "seient_en_representacio_pkey";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "sessio";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "nomlocal";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "fila";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "columna";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            foreignKey {
                name = "seient_en_representacio_fila_fkey";
                enabled = true;
                expanded = true;
                foreignKeyColumn {
                    foreignColumnName = "fila";
                    foreignTableName = "seient";
                    name = "fila";
                    enabled = true;
                    expanded = true;
                }
                foreignKeyColumn {
                    foreignColumnName = "columna";
                    foreignTableName = "seient";
                    name = "columna";
                    enabled = true;
                    expanded = true;
                }
                foreignKeyColumn {
                    foreignColumnName = "nomlocal";
                    foreignTableName = "seient";
                    name = "nomlocal";
                    enabled = true;
                    expanded = true;
                }
            }
            foreignKey {
                name = "seient_en_representacio_identificadorentrada_fkey";
                enabled = true;
                expanded = true;
                foreignKeyColumn {
                    foreignColumnName = "identificador";
                    foreignTableName = "entrada";
                    name = "identificadorentrada";
                    enabled = true;
                    expanded = true;
                }
            }
            foreignKey {
                name = "seient_en_representacio_sessio_fkey";
                enabled = true;
                expanded = true;
                foreignKeyColumn {
                    foreignColumnName = "sessio";
                    foreignTableName = "representacio";
                    name = "sessio";
                    enabled = true;
                    expanded = true;
                }
                foreignKeyColumn {
                    foreignColumnName = "nomlocal";
                    foreignTableName = "representacio";
                    name = "nomlocalrep";
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "sessio";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "sessio";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "sessio";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "sessio";
                enabled = true;
                expanded = true;
            }
            index {
                name = "sessio_pkey";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "sessio";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
    }
}