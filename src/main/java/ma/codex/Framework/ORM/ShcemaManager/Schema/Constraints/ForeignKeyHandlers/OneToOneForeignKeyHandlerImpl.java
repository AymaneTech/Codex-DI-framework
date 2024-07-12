package ma.codex.Framework.ORM.ShcemaManager.Schema.Constraints.ForeignKeyHandlers;

import ma.codex.Framework.Persistence.Annotations.Relations.Definition;

public final class OneToOneForeignKeyHandlerImpl implements ForeignKeyHandler <Definition> {
    @Override
    public String handle(Definition definition) {
        return String.format("ALTER TABLE %s ADD CONSTRAINT fk_%s_%s FOREIGN KEY (%s) REFERENCES %s(%s)",
                definition.tableName(), definition.tableName(), definition.columnName(), definition.columnName(), definition.referencedTable(), definition.referencedColumn());
    }
}