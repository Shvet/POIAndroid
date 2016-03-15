/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package com.shvet.poi.openxml4j.opc.signature;

import com.shvet.poi.openxml4j.exceptions.InvalidFormatException;
import com.shvet.poi.openxml4j.exceptions.OpenXML4JException;
import com.shvet.poi.openxml4j.opc.PackagePart;
import com.shvet.poi.openxml4j.opc.internal.ContentType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class PackageDigitalSignature extends PackagePart {

    public PackageDigitalSignature() throws InvalidFormatException {
        super(null, null, new ContentType(""));
        // TODO: Review constructor
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }

    @Override
    protected InputStream getInputStreamImpl() throws IOException {
        return null;
    }

    @Override
    protected OutputStream getOutputStreamImpl() {
        return null;
    }

    @Override
    public boolean load(InputStream ios) throws InvalidFormatException {
        return false;
    }

    @Override
    public boolean save(OutputStream zos) throws OpenXML4JException {
        return false;
    }
}
