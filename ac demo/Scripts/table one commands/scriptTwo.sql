--Script for Question Two:

GO
--write T-SQl to create a table with the following information, please use appropriate column name
CREATE TABLE Customer(
	customerId		INT NOT NULL			CONSTRAINT [pk_customerId]			PRIMARY KEY CLUSTERED IDENTITY(1,1), 
	firstName		NVARCHAR(256) NOT NULL,
	lastName		NVARCHAR(256) NOT NULL,
	email			NVARCHAR(256) NOT NULL,
	createdDate		DATE NOT NULL			CONSTRAINT [df_date_created]	DEFAULT GETDATE(),
	modifiedDate	DATE NOT NULL			CONSTRAINT [df_date_modified]	DEFAULT GETDATE(),
	isActive		BIT NOT NULL											DEFAULT 1
);
 
GO
--for product table, store information including
CREATE TABLE Product(
	productId		INT NOT NULL		CONSTRAINT [pk_productId]				PRIMARY KEY CLUSTERED IDENTITY(1,1),
	name			NVARCHAR(256)		NOT NULL,
    [description]	NVARCHAR(MAX)
);
   
GO

--for Order table, store information including
CREATE TABLE [Order](
	orderId		    INT NOT NULL		CONSTRAINT [pk_orderId]				PRIMARY KEY CLUSTERED IDENTITY(1,1),
	customerId		INT					CONSTRAINT [fk_customer_customerId]	FOREIGN KEY REFERENCES Customer(customerId),
    orderDate		DATE NOT NULL		CONSTRAINT [df_date_order]			DEFAULT GETDATE(),
	orderAmount     DECIMAL				CONSTRAINT [chk_orderAmount]		CHECK (orderAmount > 0.0),

);
     
GO	  
--for orderDetail table, store information including
CREATE TABLE [OrderDetail](
	id				INT NOT NULL		CONSTRAINT [pk_orderDetailId]		PRIMARY KEY CLUSTERED IDENTITY(1,1),
	orderID			INT	NOT NULL		CONSTRAINT [fk_order_orderId]		FOREIGN KEY REFERENCES [Order](orderId),
    productID		INT NOT NULL		CONSTRAINT [fk_product_productId]	FOREIGN KEY REFERENCES Product(productId),
	unitprice		DECIMAL				CONSTRAINT [chk_value_orderAmount]	CHECK (unitprice > 0.0),
	quality			INT					CONSTRAINT [chk_value_quality]		CHECK (quality > 1)		
);
	 
	 

