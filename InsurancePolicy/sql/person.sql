/*
 Navicat Premium Data Transfer

 Source Server         : PosgreSQL Local
 Source Server Type    : PostgreSQL
 Source Server Version : 90104
 Source Host           : localhost
 Source Database       : insurance
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90104
 File Encoding         : utf-8

 Date: 07/19/2012 10:40:03 AM
*/

-- ----------------------------
--  Table structure for "person"
-- ----------------------------
DROP TABLE IF EXISTS "person";
CREATE TABLE "person" (
	"personid" int4 NOT NULL DEFAULT nextval('person_personid_seq'::regclass),
	"name" varchar(40) NOT NULL,
	"surname" varchar(40) NOT NULL,
	"idnumber" varchar(13),
	"dateofbirth" date,
	"physicaladdress" varchar(255),
	"postaladdress" varchar(255),
	"contactnumber" varchar(25),
	"personrole" varchar(25)
)
WITH (OIDS=FALSE);
ALTER TABLE "person" OWNER TO "postgres";

-- ----------------------------
--  Primary key structure for table "person"
-- ----------------------------
ALTER TABLE "person" ADD CONSTRAINT "person_pkey" PRIMARY KEY ("personid") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- Sequence: person_personid_seq

-- DROP SEQUENCE person_personid_seq;

CREATE SEQUENCE person_personid_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE person_personid_seq
  OWNER TO postgres;