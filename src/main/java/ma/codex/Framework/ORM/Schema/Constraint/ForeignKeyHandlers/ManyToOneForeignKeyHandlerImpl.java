package ma.codex.Framework.ORM.Schema.Constraint.ForeignKeyHandlers;

import ma.codex.Framework.Persistence.Annotations.Relations.Definition;

public final class ManyToOneForeignKeyHandlerImpl implements ForeignKeyHandler {
    @Override
    public String handle(Definition definition) {
        return String.format("ALTER TABLE %s ADD CONSTRAINT fk_%s_%s FOREIGN KEY (%s) REFERENCES %s(%s)",
                definition.tableName(), definition.tableName(), definition.columnName(), definition.columnName(), definition.referencedTable(), definition.referencedColumn());
    }
}