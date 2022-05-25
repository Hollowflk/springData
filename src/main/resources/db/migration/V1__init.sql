CREATE TABLE IF NOT EXISTS products (id bigserial PRIMARY KEY, title VARCHAR(255), coast int);

INSERT INTO products (title, coast)
VALUES
    ('Cheese', 78),
    ('Milk', 233),
    ('Meat', 455),
    ('Sugar', 65),
    ('Eggs', 23),
    ('Cola', 11),
    ('Pepsi', 231),
    ('Bread', 67),
    ('Chocolate', 793),
    ('Rice', 55),
    ('Buckwheat', 24),
    ('Cereals', 44),
    ('Pasta', 567),
    ('Sour cream', 89),
    ('Ketchup', 111),
    ('Mayonnaise', 200),
    ('Sausage', 256),
    ('Potato', 117),
    ('Cucumber', 233),
    ('Onion', 768);
