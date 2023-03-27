use olsker;
insert into roles (privilege)
    values
        ('user'),
        ('admin');

insert into user (email, password, role)
    values
        ('user@email.dk', '1234', 1),
        ('admin@email.dk', '1234', 2);

insert into cupcake_top (topping, price)
    values
        ('Chocolate', 5.00),
        ('Blueberry', 5.00),
        ('Rasberry', 5.00),
        ('Crispy', 6.00),
        ('Strawberry', 6.00),
        ('Rum&Raisin', 7.00),
        ('Orange', 8.00),
        ('Lemon', 8.00),
        ('BlueCheese', 9.00);

insert into cupcake_bottom (bottom, price)
    values
        ('Chocolate', 5.00),
        ('Vanilla', 5.00),
        ('Nutmeg', 5.00),
        ('Pistacio', 6.00),
        ('Almond', 7.00);


