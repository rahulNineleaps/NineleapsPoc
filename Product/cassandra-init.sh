CQL="DROP keyspace test101;

CREATE KEYSPACE test101
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

create table test101."product"(supplierid int, productid int,name Text, price decimal, description Text, Primary Key ((supplierid,productid)) );
CREATE TABLE test101."supplier"(
	id int,
	email varchar,
	name varchar,
	PRIMARY KEY (id)
);

CREATE TYPE  test101."item_entity" (product_id int,price double,quantity int);

CREATE TABLE  test101."order_items"
(id int,
date text,
customer_name text,
customer_email text,
customer_address text,
total double,
item_entity list<frozen<item_entity>>,
PRIMARY KEY (id,customer_email));"

until echo $CQL | cqlsh; do
  echo "cqlsh: Cassandra is unavailable to initialize - will retry later"
  sleep 2
done &

exec /docker-entrypoint.sh "$@"