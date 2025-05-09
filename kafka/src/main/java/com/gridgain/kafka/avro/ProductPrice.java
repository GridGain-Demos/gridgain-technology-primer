package com.gridgain.kafka.avro;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class ProductPrice extends org.apache.avro.specific.SpecificRecordBase
		implements org.apache.avro.specific.SpecificRecord {
	private static final long serialVersionUID = 7872784302561748437L;

	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse(
			"{\"type\":\"record\",\"name\":\"ProductPrice\",\"namespace\":\"com.gridgain.dih.kafka.avro\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Trade ID\"},{\"name\":\"time\",\"type\":\"long\",\"doc\":\"time\"},{\"name\":\"symbol\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Stock Symbol\"},{\"name\":\"price\",\"type\":\"double\",\"doc\":\"Price\"}],\"version\":\"1\"}");

	public static org.apache.avro.Schema getClassSchema() {
		return SCHEMA$;
	}

	private static final SpecificData MODEL$ = new SpecificData();

	private static final BinaryMessageEncoder<ProductPrice> ENCODER = new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

	private static final BinaryMessageDecoder<ProductPrice> DECODER = new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

	/**
	 * Return the BinaryMessageEncoder instance used by this class.
	 * 
	 * @return the message encoder used by this class
	 */
	public static BinaryMessageEncoder<ProductPrice> getEncoder() {
		return ENCODER;
	}

	/**
	 * Return the BinaryMessageDecoder instance used by this class.
	 * 
	 * @return the message decoder used by this class
	 */
	public static BinaryMessageDecoder<ProductPrice> getDecoder() {
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
	public static BinaryMessageDecoder<ProductPrice> createDecoder(SchemaStore resolver) {
		return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
	}

	/**
	 * Serializes this ProductPrice to a ByteBuffer.
	 * 
	 * @return a buffer holding the serialized data for this instance
	 * @throws java.io.IOException if this instance could not be serialized
	 */
	public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
		return ENCODER.encode(this);
	}

	/**
	 * Deserializes a ProductPrice from a ByteBuffer.
	 * 
	 * @param b a byte buffer holding serialized data for an instance of this class
	 * @return a ProductPrice instance decoded from the given buffer
	 * @throws java.io.IOException if the given bytes could not be deserialized into
	 *                             an instance of this class
	 */
	public static ProductPrice fromByteBuffer(java.nio.ByteBuffer b) throws java.io.IOException {
		return DECODER.decode(b);
	}

	/** Trade ID */
	private java.lang.String id;
	/** time */
	private long time;
	/** Stock Symbol */
	private java.lang.String symbol;
	/** Price */
	private double price;

	/**
	 * Default constructor. Note that this does not initialize fields to their
	 * default values from the schema. If that is desired then one should use
	 * <code>newBuilder()</code>.
	 */
	public ProductPrice() {
	}

	/**
	 * All-args constructor.
	 * 
	 * @param id     Trade ID
	 * @param time   time
	 * @param symbol Stock Symbol
	 * @param price  Price
	 */
	public ProductPrice(java.lang.String id, java.lang.Long time, java.lang.String symbol, java.lang.Double price) {
		this.id = id;
		this.time = time;
		this.symbol = symbol;
		this.price = price;
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
			return time;
		case 2:
			return symbol;
		case 3:
			return price;
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
			time = (java.lang.Long) value$;
			break;
		case 2:
			symbol = value$ != null ? value$.toString() : null;
			break;
		case 3:
			price = (java.lang.Double) value$;
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
	 * Gets the value of the 'time' field.
	 * 
	 * @return time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * Sets the value of the 'time' field. time
	 * 
	 * @param value the value to set.
	 */
	public void setTime(long value) {
		this.time = value;
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
	 * Gets the value of the 'price' field.
	 * 
	 * @return Price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the value of the 'price' field. Price
	 * 
	 * @param value the value to set.
	 */
	public void setPrice(double value) {
		this.price = value;
	}

	/**
	 * Creates a new ProductPrice RecordBuilder.
	 * 
	 * @return A new ProductPrice RecordBuilder
	 */
	public static com.gridgain.kafka.avro.ProductPrice.Builder newBuilder() {
		return new com.gridgain.kafka.avro.ProductPrice.Builder();
	}

	/**
	 * Creates a new ProductPrice RecordBuilder by copying an existing Builder.
	 * 
	 * @param other The existing builder to copy.
	 * @return A new ProductPrice RecordBuilder
	 */
	public static com.gridgain.kafka.avro.ProductPrice.Builder newBuilder(
			com.gridgain.kafka.avro.ProductPrice.Builder other) {
		if (other == null) {
			return new com.gridgain.kafka.avro.ProductPrice.Builder();
		} else {
			return new com.gridgain.kafka.avro.ProductPrice.Builder(other);
		}
	}

	/**
	 * Creates a new ProductPrice RecordBuilder by copying an existing ProductPrice
	 * instance.
	 * 
	 * @param other The existing instance to copy.
	 * @return A new ProductPrice RecordBuilder
	 */
	public static com.gridgain.kafka.avro.ProductPrice.Builder newBuilder(
			com.gridgain.kafka.avro.ProductPrice other) {
		if (other == null) {
			return new com.gridgain.kafka.avro.ProductPrice.Builder();
		} else {
			return new com.gridgain.kafka.avro.ProductPrice.Builder(other);
		}
	}

	/**
	 * RecordBuilder for ProductPrice instances.
	 */
	@org.apache.avro.specific.AvroGenerated
	public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ProductPrice>
			implements org.apache.avro.data.RecordBuilder<ProductPrice> {

		/** Trade ID */
		private java.lang.String id;
		/** time */
		private long time;
		/** Stock Symbol */
		private java.lang.String symbol;
		/** Price */
		private double price;

		/** Creates a new Builder */
		private Builder() {
			super(SCHEMA$, MODEL$);
		}

		/**
		 * Creates a Builder by copying an existing Builder.
		 * 
		 * @param other The existing Builder to copy.
		 */
		private Builder(com.gridgain.kafka.avro.ProductPrice.Builder other) {
			super(other);
			if (isValidValue(fields()[0], other.id)) {
				this.id = data().deepCopy(fields()[0].schema(), other.id);
				fieldSetFlags()[0] = other.fieldSetFlags()[0];
			}
			if (isValidValue(fields()[1], other.time)) {
				this.time = data().deepCopy(fields()[1].schema(), other.time);
				fieldSetFlags()[1] = other.fieldSetFlags()[1];
			}
			if (isValidValue(fields()[2], other.symbol)) {
				this.symbol = data().deepCopy(fields()[2].schema(), other.symbol);
				fieldSetFlags()[2] = other.fieldSetFlags()[2];
			}
			if (isValidValue(fields()[3], other.price)) {
				this.price = data().deepCopy(fields()[3].schema(), other.price);
				fieldSetFlags()[3] = other.fieldSetFlags()[3];
			}
		}

		/**
		 * Creates a Builder by copying an existing ProductPrice instance
		 * 
		 * @param other The existing instance to copy.
		 */
		private Builder(com.gridgain.kafka.avro.ProductPrice other) {
			super(SCHEMA$, MODEL$);
			if (isValidValue(fields()[0], other.id)) {
				this.id = data().deepCopy(fields()[0].schema(), other.id);
				fieldSetFlags()[0] = true;
			}
			if (isValidValue(fields()[1], other.time)) {
				this.time = data().deepCopy(fields()[1].schema(), other.time);
				fieldSetFlags()[1] = true;
			}
			if (isValidValue(fields()[2], other.symbol)) {
				this.symbol = data().deepCopy(fields()[2].schema(), other.symbol);
				fieldSetFlags()[2] = true;
			}
			if (isValidValue(fields()[3], other.price)) {
				this.price = data().deepCopy(fields()[3].schema(), other.price);
				fieldSetFlags()[3] = true;
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
		public com.gridgain.kafka.avro.ProductPrice.Builder setId(java.lang.String value) {
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
		public com.gridgain.kafka.avro.ProductPrice.Builder clearId() {
			id = null;
			fieldSetFlags()[0] = false;
			return this;
		}

		/**
		 * Gets the value of the 'time' field. time
		 * 
		 * @return The value.
		 */
		public long getTime() {
			return time;
		}

		/**
		 * Sets the value of the 'time' field. time
		 * 
		 * @param value The value of 'time'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.ProductPrice.Builder setTime(long value) {
			validate(fields()[1], value);
			this.time = value;
			fieldSetFlags()[1] = true;
			return this;
		}

		/**
		 * Checks whether the 'time' field has been set. time
		 * 
		 * @return True if the 'time' field has been set, false otherwise.
		 */
		public boolean hasTime() {
			return fieldSetFlags()[1];
		}

		/**
		 * Clears the value of the 'time' field. time
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.ProductPrice.Builder clearTime() {
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
		public com.gridgain.kafka.avro.ProductPrice.Builder setSymbol(java.lang.String value) {
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
		public com.gridgain.kafka.avro.ProductPrice.Builder clearSymbol() {
			symbol = null;
			fieldSetFlags()[2] = false;
			return this;
		}

		/**
		 * Gets the value of the 'price' field. Price
		 * 
		 * @return The value.
		 */
		public double getPrice() {
			return price;
		}

		/**
		 * Sets the value of the 'price' field. Price
		 * 
		 * @param value The value of 'price'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.ProductPrice.Builder setPrice(double value) {
			validate(fields()[3], value);
			this.price = value;
			fieldSetFlags()[3] = true;
			return this;
		}

		/**
		 * Checks whether the 'price' field has been set. Price
		 * 
		 * @return True if the 'price' field has been set, false otherwise.
		 */
		public boolean hasPrice() {
			return fieldSetFlags()[3];
		}

		/**
		 * Clears the value of the 'price' field. Price
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.ProductPrice.Builder clearPrice() {
			fieldSetFlags()[3] = false;
			return this;
		}

		@Override
		public ProductPrice build() {
			try {
				ProductPrice record = new ProductPrice();
				record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
				record.time = fieldSetFlags()[1] ? this.time : (java.lang.Long) defaultValue(fields()[1]);
				record.symbol = fieldSetFlags()[2] ? this.symbol : (java.lang.String) defaultValue(fields()[2]);
				record.price = fieldSetFlags()[3] ? this.price : (java.lang.Double) defaultValue(fields()[3]);
				return record;
			} catch (org.apache.avro.AvroMissingFieldException e) {
				throw e;
			} catch (java.lang.Exception e) {
				throw new org.apache.avro.AvroRuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumWriter<ProductPrice> WRITER$ = (org.apache.avro.io.DatumWriter<ProductPrice>) MODEL$
			.createDatumWriter(SCHEMA$);

	@Override
	public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
		WRITER$.write(this, SpecificData.getEncoder(out));
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumReader<ProductPrice> READER$ = (org.apache.avro.io.DatumReader<ProductPrice>) MODEL$
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

		out.writeLong(this.time);

		out.writeString(this.symbol);

		out.writeDouble(this.price);

	}

	@Override
	public void customDecode(org.apache.avro.io.ResolvingDecoder in) throws java.io.IOException {
		org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
		if (fieldOrder == null) {
			this.id = in.readString();

			this.time = in.readLong();

			this.symbol = in.readString();

			this.price = in.readDouble();

		} else {
			for (int i = 0; i < 4; i++) {
				switch (fieldOrder[i].pos()) {
				case 0:
					this.id = in.readString();
					break;

				case 1:
					this.time = in.readLong();
					break;

				case 2:
					this.symbol = in.readString();
					break;

				case 3:
					this.price = in.readDouble();
					break;

				default:
					throw new java.io.IOException("Corrupt ResolvingDecoder.");
				}
			}
		}
	}
}
