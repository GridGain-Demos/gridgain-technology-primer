package com.gridgain.kafka.avro;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class Holding extends org.apache.avro.specific.SpecificRecordBase
		implements org.apache.avro.specific.SpecificRecord {
	private static final long serialVersionUID = -2070212157301716819L;

	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse(
			"{\"type\":\"record\",\"name\":\"Holding\",\"namespace\":\"com.gridgain.dih.kafka.avro\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Id\"},{\"name\":\"accountId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Account Id\"},{\"name\":\"lastTradeDate\",\"type\":\"long\",\"doc\":\"Last Trade Date\"},{\"name\":\"shareCount\",\"type\":\"long\",\"doc\":\"Share Count\"},{\"name\":\"symbol\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Symbol\"}],\"version\":\"1\"}");

	public static org.apache.avro.Schema getClassSchema() {
		return SCHEMA$;
	}

	private static final SpecificData MODEL$ = new SpecificData();

	private static final BinaryMessageEncoder<Holding> ENCODER = new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

	private static final BinaryMessageDecoder<Holding> DECODER = new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

	/**
	 * Return the BinaryMessageEncoder instance used by this class.
	 * 
	 * @return the message encoder used by this class
	 */
	public static BinaryMessageEncoder<Holding> getEncoder() {
		return ENCODER;
	}

	/**
	 * Return the BinaryMessageDecoder instance used by this class.
	 * 
	 * @return the message decoder used by this class
	 */
	public static BinaryMessageDecoder<Holding> getDecoder() {
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
	public static BinaryMessageDecoder<Holding> createDecoder(SchemaStore resolver) {
		return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
	}

	/**
	 * Serializes this Holding to a ByteBuffer.
	 * 
	 * @return a buffer holding the serialized data for this instance
	 * @throws java.io.IOException if this instance could not be serialized
	 */
	public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
		return ENCODER.encode(this);
	}

	/**
	 * Deserializes a Holding from a ByteBuffer.
	 * 
	 * @param b a byte buffer holding serialized data for an instance of this class
	 * @return a Holding instance decoded from the given buffer
	 * @throws java.io.IOException if the given bytes could not be deserialized into
	 *                             an instance of this class
	 */
	public static Holding fromByteBuffer(java.nio.ByteBuffer b) throws java.io.IOException {
		return DECODER.decode(b);
	}

	/** Id */
	private java.lang.String id;
	/** Account Id */
	private java.lang.String accountId;
	/** Last Trade Date */
	private long lastTradeDate;
	/** Share Count */
	private long shareCount;
	/** Symbol */
	private java.lang.String symbol;

	/**
	 * Default constructor. Note that this does not initialize fields to their
	 * default values from the schema. If that is desired then one should use
	 * <code>newBuilder()</code>.
	 */
	public Holding() {
	}

	/**
	 * All-args constructor.
	 * 
	 * @param id            Id
	 * @param accountId     Account Id
	 * @param lastTradeDate Last Trade Date
	 * @param shareCount    Share Count
	 * @param symbol        Symbol
	 */
	public Holding(java.lang.String id, java.lang.String accountId, java.lang.Long lastTradeDate,
			java.lang.Long shareCount, java.lang.String symbol) {
		this.id = id;
		this.accountId = accountId;
		this.lastTradeDate = lastTradeDate;
		this.shareCount = shareCount;
		this.symbol = symbol;
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
			return lastTradeDate;
		case 3:
			return shareCount;
		case 4:
			return symbol;
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
			lastTradeDate = (java.lang.Long) value$;
			break;
		case 3:
			shareCount = (java.lang.Long) value$;
			break;
		case 4:
			symbol = value$ != null ? value$.toString() : null;
			break;
		default:
			throw new IndexOutOfBoundsException("Invalid index: " + field$);
		}
	}

	/**
	 * Gets the value of the 'id' field.
	 * 
	 * @return Id
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * Sets the value of the 'id' field. Id
	 * 
	 * @param value the value to set.
	 */
	public void setId(java.lang.String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the 'accountId' field.
	 * 
	 * @return Account Id
	 */
	public java.lang.String getAccountId() {
		return accountId;
	}

	/**
	 * Sets the value of the 'accountId' field. Account Id
	 * 
	 * @param value the value to set.
	 */
	public void setAccountId(java.lang.String value) {
		this.accountId = value;
	}

	/**
	 * Gets the value of the 'lastTradeDate' field.
	 * 
	 * @return Last Trade Date
	 */
	public long getLastTradeDate() {
		return lastTradeDate;
	}

	/**
	 * Sets the value of the 'lastTradeDate' field. Last Trade Date
	 * 
	 * @param value the value to set.
	 */
	public void setLastTradeDate(long value) {
		this.lastTradeDate = value;
	}

	/**
	 * Gets the value of the 'shareCount' field.
	 * 
	 * @return Share Count
	 */
	public long getShareCount() {
		return shareCount;
	}

	/**
	 * Sets the value of the 'shareCount' field. Share Count
	 * 
	 * @param value the value to set.
	 */
	public void setShareCount(long value) {
		this.shareCount = value;
	}

	/**
	 * Gets the value of the 'symbol' field.
	 * 
	 * @return Symbol
	 */
	public java.lang.String getSymbol() {
		return symbol;
	}

	/**
	 * Sets the value of the 'symbol' field. Symbol
	 * 
	 * @param value the value to set.
	 */
	public void setSymbol(java.lang.String value) {
		this.symbol = value;
	}

	/**
	 * Creates a new Holding RecordBuilder.
	 * 
	 * @return A new Holding RecordBuilder
	 */
	public static com.gridgain.kafka.avro.Holding.Builder newBuilder() {
		return new com.gridgain.kafka.avro.Holding.Builder();
	}

	/**
	 * Creates a new Holding RecordBuilder by copying an existing Builder.
	 * 
	 * @param other The existing builder to copy.
	 * @return A new Holding RecordBuilder
	 */
	public static com.gridgain.kafka.avro.Holding.Builder newBuilder(
			com.gridgain.kafka.avro.Holding.Builder other) {
		if (other == null) {
			return new com.gridgain.kafka.avro.Holding.Builder();
		} else {
			return new com.gridgain.kafka.avro.Holding.Builder(other);
		}
	}

	/**
	 * Creates a new Holding RecordBuilder by copying an existing Holding instance.
	 * 
	 * @param other The existing instance to copy.
	 * @return A new Holding RecordBuilder
	 */
	public static com.gridgain.kafka.avro.Holding.Builder newBuilder(com.gridgain.kafka.avro.Holding other) {
		if (other == null) {
			return new com.gridgain.kafka.avro.Holding.Builder();
		} else {
			return new com.gridgain.kafka.avro.Holding.Builder(other);
		}
	}

	/**
	 * RecordBuilder for Holding instances.
	 */
	@org.apache.avro.specific.AvroGenerated
	public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Holding>
			implements org.apache.avro.data.RecordBuilder<Holding> {

		/** Id */
		private java.lang.String id;
		/** Account Id */
		private java.lang.String accountId;
		/** Last Trade Date */
		private long lastTradeDate;
		/** Share Count */
		private long shareCount;
		/** Symbol */
		private java.lang.String symbol;

		/** Creates a new Builder */
		private Builder() {
			super(SCHEMA$, MODEL$);
		}

		/**
		 * Creates a Builder by copying an existing Builder.
		 * 
		 * @param other The existing Builder to copy.
		 */
		private Builder(com.gridgain.kafka.avro.Holding.Builder other) {
			super(other);
			if (isValidValue(fields()[0], other.id)) {
				this.id = data().deepCopy(fields()[0].schema(), other.id);
				fieldSetFlags()[0] = other.fieldSetFlags()[0];
			}
			if (isValidValue(fields()[1], other.accountId)) {
				this.accountId = data().deepCopy(fields()[1].schema(), other.accountId);
				fieldSetFlags()[1] = other.fieldSetFlags()[1];
			}
			if (isValidValue(fields()[2], other.lastTradeDate)) {
				this.lastTradeDate = data().deepCopy(fields()[2].schema(), other.lastTradeDate);
				fieldSetFlags()[2] = other.fieldSetFlags()[2];
			}
			if (isValidValue(fields()[3], other.shareCount)) {
				this.shareCount = data().deepCopy(fields()[3].schema(), other.shareCount);
				fieldSetFlags()[3] = other.fieldSetFlags()[3];
			}
			if (isValidValue(fields()[4], other.symbol)) {
				this.symbol = data().deepCopy(fields()[4].schema(), other.symbol);
				fieldSetFlags()[4] = other.fieldSetFlags()[4];
			}
		}

		/**
		 * Creates a Builder by copying an existing Holding instance
		 * 
		 * @param other The existing instance to copy.
		 */
		private Builder(com.gridgain.kafka.avro.Holding other) {
			super(SCHEMA$, MODEL$);
			if (isValidValue(fields()[0], other.id)) {
				this.id = data().deepCopy(fields()[0].schema(), other.id);
				fieldSetFlags()[0] = true;
			}
			if (isValidValue(fields()[1], other.accountId)) {
				this.accountId = data().deepCopy(fields()[1].schema(), other.accountId);
				fieldSetFlags()[1] = true;
			}
			if (isValidValue(fields()[2], other.lastTradeDate)) {
				this.lastTradeDate = data().deepCopy(fields()[2].schema(), other.lastTradeDate);
				fieldSetFlags()[2] = true;
			}
			if (isValidValue(fields()[3], other.shareCount)) {
				this.shareCount = data().deepCopy(fields()[3].schema(), other.shareCount);
				fieldSetFlags()[3] = true;
			}
			if (isValidValue(fields()[4], other.symbol)) {
				this.symbol = data().deepCopy(fields()[4].schema(), other.symbol);
				fieldSetFlags()[4] = true;
			}
		}

		/**
		 * Gets the value of the 'id' field. Id
		 * 
		 * @return The value.
		 */
		public java.lang.String getId() {
			return id;
		}

		/**
		 * Sets the value of the 'id' field. Id
		 * 
		 * @param value The value of 'id'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Holding.Builder setId(java.lang.String value) {
			validate(fields()[0], value);
			this.id = value;
			fieldSetFlags()[0] = true;
			return this;
		}

		/**
		 * Checks whether the 'id' field has been set. Id
		 * 
		 * @return True if the 'id' field has been set, false otherwise.
		 */
		public boolean hasId() {
			return fieldSetFlags()[0];
		}

		/**
		 * Clears the value of the 'id' field. Id
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Holding.Builder clearId() {
			id = null;
			fieldSetFlags()[0] = false;
			return this;
		}

		/**
		 * Gets the value of the 'accountId' field. Account Id
		 * 
		 * @return The value.
		 */
		public java.lang.String getAccountId() {
			return accountId;
		}

		/**
		 * Sets the value of the 'accountId' field. Account Id
		 * 
		 * @param value The value of 'accountId'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Holding.Builder setAccountId(java.lang.String value) {
			validate(fields()[1], value);
			this.accountId = value;
			fieldSetFlags()[1] = true;
			return this;
		}

		/**
		 * Checks whether the 'accountId' field has been set. Account Id
		 * 
		 * @return True if the 'accountId' field has been set, false otherwise.
		 */
		public boolean hasAccountId() {
			return fieldSetFlags()[1];
		}

		/**
		 * Clears the value of the 'accountId' field. Account Id
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Holding.Builder clearAccountId() {
			accountId = null;
			fieldSetFlags()[1] = false;
			return this;
		}

		/**
		 * Gets the value of the 'lastTradeDate' field. Last Trade Date
		 * 
		 * @return The value.
		 */
		public long getLastTradeDate() {
			return lastTradeDate;
		}

		/**
		 * Sets the value of the 'lastTradeDate' field. Last Trade Date
		 * 
		 * @param value The value of 'lastTradeDate'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Holding.Builder setLastTradeDate(long value) {
			validate(fields()[2], value);
			this.lastTradeDate = value;
			fieldSetFlags()[2] = true;
			return this;
		}

		/**
		 * Checks whether the 'lastTradeDate' field has been set. Last Trade Date
		 * 
		 * @return True if the 'lastTradeDate' field has been set, false otherwise.
		 */
		public boolean hasLastTradeDate() {
			return fieldSetFlags()[2];
		}

		/**
		 * Clears the value of the 'lastTradeDate' field. Last Trade Date
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Holding.Builder clearLastTradeDate() {
			fieldSetFlags()[2] = false;
			return this;
		}

		/**
		 * Gets the value of the 'shareCount' field. Share Count
		 * 
		 * @return The value.
		 */
		public long getShareCount() {
			return shareCount;
		}

		/**
		 * Sets the value of the 'shareCount' field. Share Count
		 * 
		 * @param value The value of 'shareCount'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Holding.Builder setShareCount(long value) {
			validate(fields()[3], value);
			this.shareCount = value;
			fieldSetFlags()[3] = true;
			return this;
		}

		/**
		 * Checks whether the 'shareCount' field has been set. Share Count
		 * 
		 * @return True if the 'shareCount' field has been set, false otherwise.
		 */
		public boolean hasShareCount() {
			return fieldSetFlags()[3];
		}

		/**
		 * Clears the value of the 'shareCount' field. Share Count
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Holding.Builder clearShareCount() {
			fieldSetFlags()[3] = false;
			return this;
		}

		/**
		 * Gets the value of the 'symbol' field. Symbol
		 * 
		 * @return The value.
		 */
		public java.lang.String getSymbol() {
			return symbol;
		}

		/**
		 * Sets the value of the 'symbol' field. Symbol
		 * 
		 * @param value The value of 'symbol'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Holding.Builder setSymbol(java.lang.String value) {
			validate(fields()[4], value);
			this.symbol = value;
			fieldSetFlags()[4] = true;
			return this;
		}

		/**
		 * Checks whether the 'symbol' field has been set. Symbol
		 * 
		 * @return True if the 'symbol' field has been set, false otherwise.
		 */
		public boolean hasSymbol() {
			return fieldSetFlags()[4];
		}

		/**
		 * Clears the value of the 'symbol' field. Symbol
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Holding.Builder clearSymbol() {
			symbol = null;
			fieldSetFlags()[4] = false;
			return this;
		}

		@Override

		public Holding build() {
			try {
				Holding record = new Holding();
				record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
				record.accountId = fieldSetFlags()[1] ? this.accountId : (java.lang.String) defaultValue(fields()[1]);
				record.lastTradeDate = fieldSetFlags()[2] ? this.lastTradeDate
						: (java.lang.Long) defaultValue(fields()[2]);
				record.shareCount = fieldSetFlags()[3] ? this.shareCount : (java.lang.Long) defaultValue(fields()[3]);
				record.symbol = fieldSetFlags()[4] ? this.symbol : (java.lang.String) defaultValue(fields()[4]);
				return record;
			} catch (org.apache.avro.AvroMissingFieldException e) {
				throw e;
			} catch (java.lang.Exception e) {
				throw new org.apache.avro.AvroRuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumWriter<Holding> WRITER$ = (org.apache.avro.io.DatumWriter<Holding>) MODEL$
			.createDatumWriter(SCHEMA$);

	@Override
	public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
		WRITER$.write(this, SpecificData.getEncoder(out));
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumReader<Holding> READER$ = (org.apache.avro.io.DatumReader<Holding>) MODEL$
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

		out.writeLong(this.lastTradeDate);

		out.writeLong(this.shareCount);

		out.writeString(this.symbol);

	}

	@Override
	public void customDecode(org.apache.avro.io.ResolvingDecoder in) throws java.io.IOException {
		org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
		if (fieldOrder == null) {
			this.id = in.readString();

			this.accountId = in.readString();

			this.lastTradeDate = in.readLong();

			this.shareCount = in.readLong();

			this.symbol = in.readString();

		} else {
			for (int i = 0; i < 5; i++) {
				switch (fieldOrder[i].pos()) {
				case 0:
					this.id = in.readString();
					break;

				case 1:
					this.accountId = in.readString();
					break;

				case 2:
					this.lastTradeDate = in.readLong();
					break;

				case 3:
					this.shareCount = in.readLong();
					break;

				case 4:
					this.symbol = in.readString();
					break;

				default:
					throw new java.io.IOException("Corrupt ResolvingDecoder.");
				}
			}
		}
	}
}
