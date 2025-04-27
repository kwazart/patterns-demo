package dsl.sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqlBuilderDSL {

    public static class QueryBuilder {
        private final String table;
        private final List<String> selects = new ArrayList<>();
        private final List<String> joins = new ArrayList<>();
        private final List<String> wheres = new ArrayList<>();
        private final List<String> groupBys = new ArrayList<>();
        private final List<String> havings = new ArrayList<>();
        private final List<String> orderBys = new ArrayList<>();
        private Integer limit;
        private Integer offset;

        private QueryBuilder(String table) {
            this.table = table;
        }

        public QueryBuilder select(String... columns) {
            selects.addAll(Arrays.asList(columns));
            return this;
        }

        public QueryBuilder join(String joinClause) {
            joins.add(joinClause);
            return this;
        }

        public QueryBuilder where(String condition) {
            wheres.add(condition);
            return this;
        }

        public QueryBuilder groupBy(String... columns) {
            groupBys.addAll(Arrays.asList(columns));
            return this;
        }

        public QueryBuilder having(String condition) {
            havings.add(condition);
            return this;
        }

        public QueryBuilder orderBy(String... columns) {
            orderBys.addAll(Arrays.asList(columns));
            return this;
        }

        public QueryBuilder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public QueryBuilder offset(int offset) {
            this.offset = offset;
            return this;
        }

        public String build() {
            StringBuilder sql = new StringBuilder("SELECT ");

            // SELECT часть
            if (selects.isEmpty()) {
                sql.append("*");
            } else {
                sql.append(String.join(", ", selects));
            }

            // FROM часть
            sql.append(" FROM ").append(table);

            // JOIN части
            if (!joins.isEmpty()) {
                sql.append(" ").append(String.join(" ", joins));
            }

            // WHERE часть
            if (!wheres.isEmpty()) {
                sql.append(" WHERE ").append(String.join(" AND ", wheres));
            }

            // GROUP BY часть
            if (!groupBys.isEmpty()) {
                sql.append(" GROUP BY ").append(String.join(", ", groupBys));
            }

            // GROUP BY часть
            if (!groupBys.isEmpty()) {
                sql.append(" HAVING ").append(String.join(" AND ", havings));
            }

            // ORDER BY часть
            if (!orderBys.isEmpty()) {
                sql.append(" ORDER BY ").append(String.join(", ", orderBys));
            }

            // LIMIT и OFFSET
            if (limit != null) {
                sql.append(" LIMIT ").append(limit);
            }
            if (offset != null) {
                sql.append(" OFFSET ").append(offset);
            }

            return sql.toString();
        }
    }

    // Точка входа DSL
    public static QueryBuilder from(String table) {
        return new QueryBuilder(table);
    }

    // Пример использования
    public static void main(String[] args) {
        String sqlQuery = from("users")
                .select("id", "name", "email")
                .join("INNER JOIN departments ON users.department_id = departments.id")
                .where("users.active = true")
                .where("departments.name = 'Engineering'")
                .orderBy("users.name ASC")
                .limit(10)
                .offset(5)
                .build();

        System.out.println("Generated SQL:\n" + sqlQuery);

        // Более сложный пример
        String complexQuery = from("orders")
                .select("orders.id", "customers.name", "SUM(order_items.quantity * products.price) AS total")
                .join("INNER JOIN customers ON orders.customer_id = customers.id")
                .join("INNER JOIN order_items ON orders.id = order_items.order_id")
                .join("INNER JOIN products ON order_items.product_id = products.id")
                .where("orders.date >= '2023-01-01'")
                .groupBy("orders.id", "customers.name")
                .having("SUM(order_items.quantity * products.price) > 1000")
                .orderBy("total DESC")
                .build();

        System.out.println("\nComplex SQL:\n" + complexQuery);
    }
}