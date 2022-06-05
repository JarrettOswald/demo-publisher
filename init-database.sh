#!/bin/bash
psql -U postgres <<-EOSQL
   CREATE SCHEMA IF NOT EXISTS liquibase;
EOSQL