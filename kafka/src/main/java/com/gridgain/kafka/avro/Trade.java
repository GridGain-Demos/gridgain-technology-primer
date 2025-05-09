package com.gridgain.kafka.avro;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class Trade extends org.apache.avro.specific.SpecificRecordBase
		implements org.apache.avro.specific.SpecificRecord {
	private static final long serialVersionUID = -5862721997068257131L;

	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse(
			"{\"type\":\"record\",\"name\":\"Trade\",\"namespace\":\"com.gridgain.dih.kafka.avro\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Trade ID\"},{\"name\":\"accountId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Account ID\"},{\"name\":\"symbol\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Stock Symbol\"},{\"name\":\"order_quantity\",\"type\":\"int\",\"doc\":\"Order Quantity\"},{\"name\":\"bid_price\",\"type\":\"double\",\"doc\":\"Bid Price\"},{\"name\":\"trade_type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Trade Type\"},{\"name\":\"order_date\",\"type\":\"long\",\"doc\":\"Order Date\"}],\"version\":\"1\"}");

	public static org.apache.avro.Schema getClassSchema() {
		return SCHEMA$;
	}

	private static final SpecificData MODEL$ = new SpecificData();

	private static final BinaryMessageEncoder<Trade> ENCODER = new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

	private static final BinaryMessageDecoder<Trade> DECODER = new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

	/**
	 * Return the BinaryMessageEncoder instance used by this class.
	 * 
	 * @return the message encoder used by this class
	 */
	public static BinaryMessageEncoder<Trade> getEncoder() {
		return ENCODER;
	}

	/**
	 * Return the BinaryMessageDecoder instance used by this class.
	 * 
	 * @return the message decoder used by this class
	 */
	public static BinaryMessageDecoder<Trade> getDecoder() {
		return DECODER;
	}

	/**
	 * Create a new BinaryMessageDecoder instance for this class that uses the
	 * specified {@link SchemaStore}.
	 * 
	 * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
	 * @return a BinaryMessageDecoder instance for this class backed by the given
	 *         SchemaStore
	 */
	public static BinaryMessageDecoder<Trade> createDecoder(SchemaStore resolver) {
		return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
	}

	/**
	 * Serializes this Trade to a ByteBuffer.
	 * 
	 * @return a buffer holding the serialized data for this instance
	 * @throws java.io.IOException if this instance could not be serialized
	 */
	public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
		return ENCODER.encode(this);
	}

	/**
	 * Deserializes a Trade from a ByteBuffer.
	 * 
	 * @param b a byte buffer holding serialized data for an instance of this class
	 * @return a Trade instance decoded from the given buffer
	 * @throws java.io.IOException if the given bytes could not be deserialized into
	 *                             an instance of this class
	 */
	public static Trade fromByteBuffer(java.nio.ByteBuffer b) throws java.io.IOException {
		return DECODER.decode(b);
	}

	/** Trade ID */
	private java.lang.String id;
	/** Account ID */
	private java.lang.String accountId;
	/** Stock Symbol */
	private java.lang.String symbol;
	/** Order Quantity */
	private int order_quantity;
	/** Bid Price */
	private double bid_price;
	/** Trade Type */
	private java.lang.String trade_type;
	/** Order Date */
	private long order_date;

	/**
	 * Default constructor. Note that this does not initialize fields to their
	 * default values from the schema. If that is desired then one should use
	 * <code>newBuilder()</code>.
	 */
	public Trade() {
	}

	/**
	 * All-args constructor.
	 * 
	 * @param id             Trade ID
	 * @param accountId      Account ID
	 * @param symbol         Stock Symbol
	 * @param order_quantity Order Quantity
	 * @param bid_price      Bid Price
	 * @param trade_type     Trade Type
	 * @param order_date     Order Date
	 */
	public Trade(java.lang.String id, java.lang.String accountId, java.lang.String symbol,
			java.lang.Integer order_quantity, java.lang.Double bid_price, java.lang.String trade_type,
			java.lang.Long order_date) {
		this.id = id;
		this.accountId = accountId;
		this.symbol = symbol;
		this.order_quantity = order_quantity;
		this.bid_price = bid_price;
		this.trade_type = trade_type;
		this.order_date = order_date;
	}

	@Override
	public org.apache.avro.specific.SpecificData getSpecificData() {
		return MODEL$;
	}

	@Override
	public org.apache.avro.Schema getSchema() {
		return SCHEMA$;
	}

	// Used by DatumWriter. Applications should not call.
	@Override
	public java.lang.Object get(int field$) {
		switch (field$) {
		case 0:
			return id;
		case 1:
			return accountId;
		case 2:
			return symbol;
		case 3:
			return order_quantity;
		case 4:
			return bid_price;
		case 5:
			return trade_type;
		case 6:
			return order_date;
		default:
			throw new IndexOutOfBoundsException("Invalid index: " + field$);
		}
	}

	// Used by DatumReader. Applications should not call.
	@Override
	public void put(int field$, java.lang.Object value$) {
		switch (field$) {
		case 0:
			id = value$ != null ? value$.toString() : null;
			break;
		case 1:
			accountId = value$ != null ? value$.toString() : null;
			break;
		case 2:
			symbol = value$ != null ? value$.toString() : null;
			break;
		case 3:
			order_quantity = (java.lang.Integer) value$;
			break;
		case 4:
			bid_price = (java.lang.Double) value$;
			break;
		case 5:
			trade_type = value$ != null ? value$.toString() : null;
			break;
		case 6:
			order_date = (java.lang.Long) value$;
			break;
		default:
			throw new IndexOutOfBoundsException("Invalid index: " + field$);
		}
	}

	/**
	 * Gets the value of the 'id' field.
	 * 
	 * @return Trade ID
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * Sets the value of the 'id' field. Trade ID
	 * 
	 * @param value the value to set.
	 */
	public void setId(java.lang.String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the 'accountId' field.
	 * 
	 * @return Account ID
	 */
	public java.lang.String getAccountId() {
		return accountId;
	}

	/**
	 * Sets the value of the 'accountId' field. Account ID
	 * 
	 * @param value the value to set.
	 */
	public void setAccountId(java.lang.String value) {
		this.accountId = value;
	}

	/**
	 * Gets the value of the 'symbol' field.
	 * 
	 * @return Stock Symbol
	 */
	public java.lang.String getSymbol() {
		return symbol;
	}

	/**
	 * Sets the value of the 'symbol' field. Stock Symbol
	 * 
	 * @param value the value to set.
	 */
	public void setSymbol(java.lang.String value) {
		this.symbol = value;
	}

	/**
	 * Gets the value of the 'order_quantity' field.
	 * 
	 * @return Order Quantity
	 */
	public int getOrderQuantity() {
		return order_quantity;
	}

	/**
	 * Sets the value of the 'order_quantity' field. Order Quantity
	 * 
	 * @param value the value to set.
	 */
	public void setOrderQuantity(int value) {
		this.order_quantity = value;
	}

	/**
	 * Gets the value of the 'bid_price' field.
	 * 
	 * @return Bid Price
	 */
	public double getBidPrice() {
		return bid_price;
	}

	/**
	 * Sets the value of the 'bid_price' field. Bid Price
	 * 
	 * @param value the value to set.
	 */
	public void setBidPrice(double value) {
		this.bid_price = value;
	}

	/**
	 * Gets the value of the 'trade_type' field.
	 * 
	 * @return Trade Type
	 */
	public java.lang.String getTradeType() {
		return trade_type;
	}

	/**
	 * Sets the value of the 'trade_type' field. Trade Type
	 * 
	 * @param value the value to set.
	 */
	public void setTradeType(java.lang.String value) {
		this.trade_type = value;
	}

	/**
	 * Gets the value of the 'order_date' field.
	 * 
	 * @return Order Date
	 */
	public long getOrderDate() {
		return order_date;
	}

	/**
	 * Sets the value of the 'order_date' field. Order Date
	 * 
	 * @param value the value to set.
	 */
	public void setOrderDate(long value) {
		this.order_date = value;
	}

	/**
	 * Creates a new Trade RecordBuilder.
	 * 
	 * @return A new Trade RecordBuilder
	 */
	public static com.gridgain.kafka.avro.Trade.Builder newBuilder() {
		return new com.gridgain.kafka.avro.Trade.Builder();
	}

	/**
	 * Creates a new Trade RecordBuilder by copying an existing Builder.
	 * 
	 * @param other The existing builder to copy.
	 * @return A new Trade RecordBuilder
	 */
	public static com.gridgain.kafka.avro.Trade.Builder newBuilder(
			com.gridgain.kafka.avro.Trade.Builder other) {
		if (other == null) {
			return new com.gridgain.kafka.avro.Trade.Builder();
		} else {
			return new com.gridgain.kafka.avro.Trade.Builder(other);
		}
	}

	/**
	 * Creates a new Trade RecordBuilder by copying an existing Trade instance.
	 * 
	 * @param other The existing instance to copy.
	 * @return A new Trade RecordBuilder
	 */
	public static com.gridgain.kafka.avro.Trade.Builder newBuilder(com.gridgain.kafka.avro.Trade other) {
		if (other == null) {
			return new com.gridgain.kafka.avro.Trade.Builder();
		} else {
			return new com.gridgain.kafka.avro.Trade.Builder(other);
		}
	}

	/**
	 * RecordBuilder for Trade instances.
	 */
	@org.apache.avro.specific.AvroGenerated
	public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Trade>
			implements org.apache.avro.data.RecordBuilder<Trade> {

		/** Trade ID */
		private java.lang.String id;
		/** Account ID */
		private java.lang.String accountId;
		/** Stock Symbol */
		private java.lang.String symbol;
		/** Order Quantity */
		private int order_quantity;
		/** Bid Price */
		private double bid_price;
		/** Trade Type */
		private java.lang.String trade_type;
		/** Order Date */
		private long order_date;

		/** Creates a new Builder */
		private Builder() {
			super(SCHEMA$, MODEL$);
		}

		/**
		 * Creates a Builder by copying an existing Builder.
		 * 
		 * @param other The existing Builder to copy.
		 */
		private Builder(com.gridgain.kafka.avro.Trade.Builder other) {
			super(other);
			if (isValidValue(fields()[0], other.id)) {
				this.id = data().deepCopy(fields()[0].schema(), other.id);
				fieldSetFlags()[0] = other.fieldSetFlags()[0];
			}
			if (isValidValue(fields()[1], other.accountId)) {
				this.accountId = data().deepCopy(fields()[1].schema(), other.accountId);
				fieldSetFlags()[1] = other.fieldSetFlags()[1];
			}
			if (isValidValue(fields()[2], other.symbol)) {
				this.symbol = data().deepCopy(fields()[2].schema(), other.symbol);
				fieldSetFlags()[2] = other.fieldSetFlags()[2];
			}
			if (isValidValue(fields()[3], other.order_quantity)) {
				this.order_quantity = data().deepCopy(fields()[3].schema(), other.order_quantity);
				fieldSetFlags()[3] = other.fieldSetFlags()[3];
			}
			if (isValidValue(fields()[4], other.bid_price)) {
				this.bid_price = data().deepCopy(fields()[4].schema(), other.bid_price);
				fieldSetFlags()[4] = other.fieldSetFlags()[4];
			}
			if (isValidValue(fields()[5], other.trade_type)) {
				this.trade_type = data().deepCopy(fields()[5].schema(), other.trade_type);
				fieldSetFlags()[5] = other.fieldSetFlags()[5];
			}
			if (isValidValue(fields()[6], other.order_date)) {
				this.order_date = data().deepCopy(fields()[6].schema(), other.order_date);
				fieldSetFlags()[6] = other.fieldSetFlags()[6];
			}
		}

		/**
		 * Creates a Builder by copying an existing Trade instance
		 * 
		 * @param other The existing instance to copy.
		 */
		private Builder(com.gridgain.kafka.avro.Trade other) {
			super(SCHEMA$, MODEL$);
			if (isValidValue(fields()[0], other.id)) {
				this.id = data().deepCopy(fields()[0].schema(), other.id);
				fieldSetFlags()[0] = true;
			}
			if (isValidValue(fields()[1], other.accountId)) {
				this.accountId = data().deepCopy(fields()[1].schema(), other.accountId);
				fieldSetFlags()[1] = true;
			}
			if (isValidValue(fields()[2], other.symbol)) {
				this.symbol = data().deepCopy(fields()[2].schema(), other.symbol);
				fieldSetFlags()[2] = true;
			}
			if (isValidValue(fields()[3], other.order_quantity)) {
				this.order_quantity = data().deepCopy(fields()[3].schema(), other.order_quantity);
				fieldSetFlags()[3] = true;
			}
			if (isValidValue(fields()[4], other.bid_price)) {
				this.bid_price = data().deepCopy(fields()[4].schema(), other.bid_price);
				fieldSetFlags()[4] = true;
			}
			if (isValidValue(fields()[5], other.trade_type)) {
				this.trade_type = data().deepCopy(fields()[5].schema(), other.trade_type);
				fieldSetFlags()[5] = true;
			}
			if (isValidValue(fields()[6], other.order_date)) {
				this.order_date = data().deepCopy(fields()[6].schema(), other.order_date);
				fieldSetFlags()[6] = true;
			}
		}

		/**
		 * Gets the value of the 'id' field. Trade ID
		 * 
		 * @return The value.
		 */
		public java.lang.String getId() {
			return id;
		}

		/**
		 * Sets the value of the 'id' field. Trade ID
		 * 
		 * @param value The value of 'id'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder setId(java.lang.String value) {
			validate(fields()[0], value);
			this.id = value;
			fieldSetFlags()[0] = true;
			return this;
		}

		/**
		 * Checks whether the 'id' field has been set. Trade ID
		 * 
		 * @return True if the 'id' field has been set, false otherwise.
		 */
		public boolean hasId() {
			return fieldSetFlags()[0];
		}

		/**
		 * Clears the value of the 'id' field. Trade ID
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder clearId() {
			id = null;
			fieldSetFlags()[0] = false;
			return this;
		}

		/**
		 * Gets the value of the 'accountId' field. Account ID
		 * 
		 * @return The value.
		 */
		public java.lang.String getAccountId() {
			return accountId;
		}

		/**
		 * Sets the value of the 'accountId' field. Account ID
		 * 
		 * @param value The value of 'accountId'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder setAccountId(java.lang.String value) {
			validate(fields()[1], value);
			this.accountId = value;
			fieldSetFlags()[1] = true;
			return this;
		}

		/**
		 * Checks whether the 'accountId' field has been set. Account ID
		 * 
		 * @return True if the 'accountId' field has been set, false otherwise.
		 */
		public boolean hasAccountId() {
			return fieldSetFlags()[1];
		}

		/**
		 * Clears the value of the 'accountId' field. Account ID
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder clearAccountId() {
			accountId = null;
			fieldSetFlags()[1] = false;
			return this;
		}

		/**
		 * Gets the value of the 'symbol' field. Stock Symbol
		 * 
		 * @return The value.
		 */
		public java.lang.String getSymbol() {
			return symbol;
		}

		/**
		 * Sets the value of the 'symbol' field. Stock Symbol
		 * 
		 * @param value The value of 'symbol'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder setSymbol(java.lang.String value) {
			validate(fields()[2], value);
			this.symbol = value;
			fieldSetFlags()[2] = true;
			return this;
		}

		/**
		 * Checks whether the 'symbol' field has been set. Stock Symbol
		 * 
		 * @return True if the 'symbol' field has been set, false otherwise.
		 */
		public boolean hasSymbol() {
			return fieldSetFlags()[2];
		}

		/**
		 * Clears the value of the 'symbol' field. Stock Symbol
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder clearSymbol() {
			symbol = null;
			fieldSetFlags()[2] = false;
			return this;
		}

		/**
		 * Gets the value of the 'order_quantity' field. Order Quantity
		 * 
		 * @return The value.
		 */
		public int getOrderQuantity() {
			return order_quantity;
		}

		/**
		 * Sets the value of the 'order_quantity' field. Order Quantity
		 * 
		 * @param value The value of 'order_quantity'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder setOrderQuantity(int value) {
			validate(fields()[3], value);
			this.order_quantity = value;
			fieldSetFlags()[3] = true;
			return this;
		}

		/**
		 * Checks whether the 'order_quantity' field has been set. Order Quantity
		 * 
		 * @return True if the 'order_quantity' field has been set, false otherwise.
		 */
		public boolean hasOrderQuantity() {
			return fieldSetFlags()[3];
		}

		/**
		 * Clears the value of the 'order_quantity' field. Order Quantity
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder clearOrderQuantity() {
			fieldSetFlags()[3] = false;
			return this;
		}

		/**
		 * Gets the value of the 'bid_price' field. Bid Price
		 * 
		 * @return The value.
		 */
		public double getBidPrice() {
			return bid_price;
		}

		/**
		 * Sets the value of the 'bid_price' field. Bid Price
		 * 
		 * @param value The value of 'bid_price'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder setBidPrice(double value) {
			validate(fields()[4], value);
			this.bid_price = value;
			fieldSetFlags()[4] = true;
			return this;
		}

		/**
		 * Checks whether the 'bid_price' field has been set. Bid Price
		 * 
		 * @return True if the 'bid_price' field has been set, false otherwise.
		 */
		public boolean hasBidPrice() {
			return fieldSetFlags()[4];
		}

		/**
		 * Clears the value of the 'bid_price' field. Bid Price
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder clearBidPrice() {
			fieldSetFlags()[4] = false;
			return this;
		}

		/**
		 * Gets the value of the 'trade_type' field. Trade Type
		 * 
		 * @return The value.
		 */
		public java.lang.String getTradeType() {
			return trade_type;
		}

		/**
		 * Sets the value of the 'trade_type' field. Trade Type
		 * 
		 * @param value The value of 'trade_type'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder setTradeType(java.lang.String value) {
			validate(fields()[5], value);
			this.trade_type = value;
			fieldSetFlags()[5] = true;
			return this;
		}

		/**
		 * Checks whether the 'trade_type' field has been set. Trade Type
		 * 
		 * @return True if the 'trade_type' field has been set, false otherwise.
		 */
		public boolean hasTradeType() {
			return fieldSetFlags()[5];
		}

		/**
		 * Clears the value of the 'trade_type' field. Trade Type
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder clearTradeType() {
			trade_type = null;
			fieldSetFlags()[5] = false;
			return this;
		}

		/**
		 * Gets the value of the 'order_date' field. Order Date
		 * 
		 * @return The value.
		 */
		public long getOrderDate() {
			return order_date;
		}

		/**
		 * Sets the value of the 'order_date' field. Order Date
		 * 
		 * @param value The value of 'order_date'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder setOrderDate(long value) {
			validate(fields()[6], value);
			this.order_date = value;
			fieldSetFlags()[6] = true;
			return this;
		}

		/**
		 * Checks whether the 'order_date' field has been set. Order Date
		 * 
		 * @return True if the 'order_date' field has been set, false otherwise.
		 */
		public boolean hasOrderDate() {
			return fieldSetFlags()[6];
		}

		/**
		 * Clears the value of the 'order_date' field. Order Date
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Trade.Builder clearOrderDate() {
			fieldSetFlags()[6] = false;
			return this;
		}

		@Override

		public Trade build() {
			try {
				Trade record = new Trade();
				record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
				record.accountId = fieldSetFlags()[1] ? this.accountId : (java.lang.String) defaultValue(fields()[1]);
				record.symbol = fieldSetFlags()[2] ? this.symbol : (java.lang.String) defaultValue(fields()[2]);
				record.order_quantity = fieldSetFlags()[3] ? this.order_quantity
						: (java.lang.Integer) defaultValue(fields()[3]);
				record.bid_price = fieldSetFlags()[4] ? this.bid_price : (java.lang.Double) defaultValue(fields()[4]);
				record.trade_type = fieldSetFlags()[5] ? this.trade_type : (java.lang.String) defaultValue(fields()[5]);
				record.order_date = fieldSetFlags()[6] ? this.order_date : (java.lang.Long) defaultValue(fields()[6]);
				return record;
			} catch (org.apache.avro.AvroMissingFieldException e) {
				throw e;
			} catch (java.lang.Exception e) {
				throw new org.apache.avro.AvroRuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumWriter<Trade> WRITER$ = (org.apache.avro.io.DatumWriter<Trade>) MODEL$
			.createDatumWriter(SCHEMA$);

	@Override
	public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
		WRITER$.write(this, SpecificData.getEncoder(out));
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumReader<Trade> READER$ = (org.apache.avro.io.DatumReader<Trade>) MODEL$
			.createDatumReader(SCHEMA$);

	@Override
	public void readExternal(java.io.ObjectInput in) throws java.io.IOException {
		READER$.read(this, SpecificData.getDecoder(in));
	}

	@Override
	protected boolean hasCustomCoders() {
		return true;
	}

	@Override
	public void customEncode(org.apache.avro.io.Encoder out) throws java.io.IOException {
		out.writeString(this.id);

		out.writeString(this.accountId);

		out.writeString(this.symbol);

		out.writeInt(this.order_quantity);

		out.writeDouble(this.bid_price);

		out.writeString(this.trade_type);

		out.writeLong(this.order_date);

	}

	@Override
	public void customDecode(org.apache.avro.io.ResolvingDecoder in) throws java.io.IOException {
		org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
		if (fieldOrder == null) {
			this.id = in.readString();

			this.accountId = in.readString();

			this.symbol = in.readString();

			this.order_quantity = in.readInt();

			this.bid_price = in.readDouble();

			this.trade_type = in.readString();

			this.order_date = in.readLong();

		} else {
			for (int i = 0; i < 7; i++) {
				switch (fieldOrder[i].pos()) {
				case 0:
					this.id = in.readString();
					break;

				case 1:
					this.accountId = in.readString();
					break;

				case 2:
					this.symbol = in.readString();
					break;

				case 3:
					this.order_quantity = in.readInt();
					break;

				case 4:
					this.bid_price = in.readDouble();
					break;

				case 5:
					this.trade_type = in.readString();
					break;

				case 6:
					this.order_date = in.readLong();
					break;

				default:
					throw new java.io.IOException("Corrupt ResolvingDecoder.");
				}
			}
		}
	}
}
