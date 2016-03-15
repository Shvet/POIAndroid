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
package com.shvet.poi.poifs.crypt;

import com.shvet.poi.poifs.filesystem.DirectoryNode;
import com.shvet.poi.poifs.filesystem.NPOIFSFileSystem;
import com.shvet.poi.poifs.filesystem.OPOIFSFileSystem;
import com.shvet.poi.poifs.filesystem.POIFSFileSystem;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

import javax.crypto.SecretKey;

public abstract class Encryptor {
    protected static final String DEFAULT_POIFS_ENTRY = Decryptor.DEFAULT_POIFS_ENTRY;
    private SecretKey secretKey;

    public static Encryptor getInstance(EncryptionInfo info) {
        return info.getEncryptor();
    }

    /**
     * Return a output stream for encrypted data.
     *
     * @param dir the node to write to
     * @return encrypted stream
     */
    public abstract OutputStream getDataStream(DirectoryNode dir)
            throws IOException, GeneralSecurityException;

    // for tests
    public abstract void confirmPassword(String password, byte keySpec[], byte keySalt[], byte verifier[], byte verifierSalt[], byte integritySalt[]);

    public abstract void confirmPassword(String password);

    public OutputStream getDataStream(NPOIFSFileSystem fs) throws IOException, GeneralSecurityException {
        return getDataStream(fs.getRoot());
    }

    public OutputStream getDataStream(OPOIFSFileSystem fs) throws IOException, GeneralSecurityException {
        return getDataStream(fs.getRoot());
    }

    public OutputStream getDataStream(POIFSFileSystem fs) throws IOException, GeneralSecurityException {
        return getDataStream(fs.getRoot());
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    protected void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }
}
