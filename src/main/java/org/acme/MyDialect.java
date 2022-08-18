package org.acme;

import io.quarkus.hibernate.orm.runtime.dialect.QuarkusPostgreSQL10Dialect;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

public class MyDialect extends QuarkusPostgreSQL10Dialect {

    @Override
    public SqlTypeDescriptor getSqlTypeDescriptorOverride(int sqlCode) {
        // Uncomment the line below to pass the test
        // return ArrayTypeDescriptor.INSTANCE;
        return super.getSqlTypeDescriptorOverride(sqlCode);
    }
}
