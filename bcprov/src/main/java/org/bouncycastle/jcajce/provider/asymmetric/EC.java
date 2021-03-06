package org.bouncycastle.jcajce.provider.asymmetric;

// BEGIN android-removed
// import org.bouncycastle.asn1.bsi.BSIObjectIdentifiers;
// import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
// import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
// END android-removed
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class EC
{
    private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric" + ".ec.";

    public static class Mappings
        extends AsymmetricAlgorithmProvider
    {
        public Mappings()
        {
        }

        public void configure(ConfigurableProvider provider)
        {
            provider.addAlgorithm("KeyAgreement.ECDH", PREFIX + "KeyAgreementSpi$DH");
            // BEGIN android-removed
            // provider.addAlgorithm("KeyAgreement.ECDHC", PREFIX + "KeyAgreementSpi$DHC");
            // provider.addAlgorithm("KeyAgreement.ECMQV", PREFIX + "KeyAgreementSpi$MQV");
            // provider.addAlgorithm("KeyAgreement." + X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme, PREFIX + "KeyAgreementSpi$DHwithSHA1KDF");
            // provider.addAlgorithm("KeyAgreement." + X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme, PREFIX + "KeyAgreementSpi$MQVwithSHA1KDF");
            // provider.addAlgorithm("KeyAgreement.ECDHWITHSHA1KDF", PREFIX + "KeyAgreementSpi$DHwithSHA1KDF");
            // END android-removed

            registerOid(provider, X9ObjectIdentifiers.id_ecPublicKey, "EC", new KeyFactorySpi.EC());
            // TODO Should this be an alias for ECDH?
            registerOid(provider, X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme, "EC", new KeyFactorySpi.EC());
            // BEGIN android-removed
            // registerOid(provider, X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme, "ECMQV", new KeyFactorySpi.ECMQV());
            //
            // // Android comment: the registration below is causing CTS tests to fail and doesn't seem
            // // to be implemented by bouncycastle (so looks like an bug in bouncycastle).
            // registerOidAlgorithmParameters(provider, X9ObjectIdentifiers.id_ecPublicKey, "EC");
            // END android-removed
            // TODO Should this be an alias for ECDH?
            // BEGIN android-removed
            // // Android comment: the registration below is causing CTS tests to fail and doesn't seem
            // // to be implemented by bouncycastle (so looks like an bug in bouncycastle).
            // registerOidAlgorithmParameters(provider, X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme, "EC");
            // registerOidAlgorithmParameters(provider, X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme, "EC");
            // END android-removed

            provider.addAlgorithm("KeyFactory.EC", PREFIX + "KeyFactorySpi$EC");
            // BEGIN android-removed
            // provider.addAlgorithm("KeyFactory.ECDSA", PREFIX + "KeyFactorySpi$ECDSA");
            // provider.addAlgorithm("KeyFactory.ECDH", PREFIX + "KeyFactorySpi$ECDH");
            // provider.addAlgorithm("KeyFactory.ECDHC", PREFIX + "KeyFactorySpi$ECDHC");
            // provider.addAlgorithm("KeyFactory.ECMQV", PREFIX + "KeyFactorySpi$ECMQV");
            // END android-removed

            provider.addAlgorithm("KeyPairGenerator.EC", PREFIX + "KeyPairGeneratorSpi$EC");
            // BEGIN android-removed
            // provider.addAlgorithm("KeyPairGenerator.ECDSA", PREFIX + "KeyPairGeneratorSpi$ECDSA");
            // provider.addAlgorithm("KeyPairGenerator.ECDH", PREFIX + "KeyPairGeneratorSpi$ECDH");
            // provider.addAlgorithm("KeyPairGenerator.ECDHWITHSHA1KDF", PREFIX + "KeyPairGeneratorSpi$ECDH");
            // provider.addAlgorithm("KeyPairGenerator.ECDHC", PREFIX + "KeyPairGeneratorSpi$ECDHC");
            // provider.addAlgorithm("KeyPairGenerator.ECIES", PREFIX + "KeyPairGeneratorSpi$ECDH");
            // provider.addAlgorithm("KeyPairGenerator.ECMQV", PREFIX + "KeyPairGeneratorSpi$ECMQV");
            //
            // provider.addAlgorithm("Cipher.ECIES", PREFIX + "IESCipher$ECIES");
            // provider.addAlgorithm("Cipher.ECIESwithAES", PREFIX + "IESCipher$ECIESwithAES");
            // provider.addAlgorithm("Cipher.ECIESWITHAES", PREFIX + "IESCipher$ECIESwithAES");
            // provider.addAlgorithm("Cipher.ECIESwithDESEDE", PREFIX + "IESCipher$ECIESwithDESede");
            // provider.addAlgorithm("Cipher.ECIESWITHDESEDE", PREFIX + "IESCipher$ECIESwithDESede");
            // provider.addAlgorithm("Cipher.ECIESwithAES-CBC", PREFIX + "IESCipher$ECIESwithAESCBC");
            // provider.addAlgorithm("Cipher.ECIESWITHAES-CBC", PREFIX + "IESCipher$ECIESwithAESCBC");
            // provider.addAlgorithm("Cipher.ECIESwithDESEDE-CBC", PREFIX + "IESCipher$ECIESwithDESedeCBC");
            // provider.addAlgorithm("Cipher.ECIESWITHDESEDE-CBC", PREFIX + "IESCipher$ECIESwithDESedeCBC");
            // END android-removed

            provider.addAlgorithm("Signature.ECDSA", PREFIX + "SignatureSpi$ecDSA");
            provider.addAlgorithm("Signature.NONEwithECDSA", PREFIX + "SignatureSpi$ecDSAnone");

            provider.addAlgorithm("Alg.Alias.Signature.SHA1withECDSA", "ECDSA");
            provider.addAlgorithm("Alg.Alias.Signature.ECDSAwithSHA1", "ECDSA");
            provider.addAlgorithm("Alg.Alias.Signature.SHA1WITHECDSA", "ECDSA");
            provider.addAlgorithm("Alg.Alias.Signature.ECDSAWITHSHA1", "ECDSA");
            provider.addAlgorithm("Alg.Alias.Signature.SHA1WithECDSA", "ECDSA");
            provider.addAlgorithm("Alg.Alias.Signature.ECDSAWithSHA1", "ECDSA");
            provider.addAlgorithm("Alg.Alias.Signature.1.2.840.10045.4.1", "ECDSA");
            // BEGIN android-removed
            // provider.addAlgorithm("Alg.Alias.Signature." + TeleTrusTObjectIdentifiers.ecSignWithSha1, "ECDSA");
            //
            // provider.addAlgorithm("Signature.DETECDSA", PREFIX + "SignatureSpi$ecDetDSA");
            // provider.addAlgorithm("Signature.SHA1WITHDETECDSA", PREFIX + "SignatureSpi$ecDetDSA");
            // provider.addAlgorithm("Signature.SHA224WITHDETECDSA", PREFIX + "SignatureSpi$ecDetDSA224");
            // provider.addAlgorithm("Signature.SHA256WITHDETECDSA", PREFIX + "SignatureSpi$ecDetDSA256");
            // provider.addAlgorithm("Signature.SHA384WITHDETECDSA", PREFIX + "SignatureSpi$ecDetDSA384");
            // provider.addAlgorithm("Signature.SHA512WITHDETECDSA", PREFIX + "SignatureSpi$ecDetDSA512");
            // END android-removed

            addSignatureAlgorithm(provider, "SHA224", "ECDSA", PREFIX + "SignatureSpi$ecDSA224", X9ObjectIdentifiers.ecdsa_with_SHA224);
            addSignatureAlgorithm(provider, "SHA256", "ECDSA", PREFIX + "SignatureSpi$ecDSA256", X9ObjectIdentifiers.ecdsa_with_SHA256);
            addSignatureAlgorithm(provider, "SHA384", "ECDSA", PREFIX + "SignatureSpi$ecDSA384", X9ObjectIdentifiers.ecdsa_with_SHA384);
            addSignatureAlgorithm(provider, "SHA512", "ECDSA", PREFIX + "SignatureSpi$ecDSA512", X9ObjectIdentifiers.ecdsa_with_SHA512);
            // BEGIN android-removed
            // addSignatureAlgorithm(provider, "RIPEMD160", "ECDSA", PREFIX + "SignatureSpi$ecDSARipeMD160",TeleTrusTObjectIdentifiers.ecSignWithRipemd160);
            //
            // provider.addAlgorithm("Signature.SHA1WITHECNR", PREFIX + "SignatureSpi$ecNR");
            // provider.addAlgorithm("Signature.SHA224WITHECNR", PREFIX + "SignatureSpi$ecNR224");
            // provider.addAlgorithm("Signature.SHA256WITHECNR", PREFIX + "SignatureSpi$ecNR256");
            // provider.addAlgorithm("Signature.SHA384WITHECNR", PREFIX + "SignatureSpi$ecNR384");
            // provider.addAlgorithm("Signature.SHA512WITHECNR", PREFIX + "SignatureSpi$ecNR512");
            //
            // addSignatureAlgorithm(provider, "SHA1", "CVC-ECDSA", PREFIX + "SignatureSpi$ecCVCDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_1);
            // addSignatureAlgorithm(provider, "SHA224", "CVC-ECDSA", PREFIX + "SignatureSpi$ecCVCDSA224", EACObjectIdentifiers.id_TA_ECDSA_SHA_224);
            // addSignatureAlgorithm(provider, "SHA256", "CVC-ECDSA", PREFIX + "SignatureSpi$ecCVCDSA256", EACObjectIdentifiers.id_TA_ECDSA_SHA_256);
            // addSignatureAlgorithm(provider, "SHA384", "CVC-ECDSA", PREFIX + "SignatureSpi$ecCVCDSA384", EACObjectIdentifiers.id_TA_ECDSA_SHA_384);
            // addSignatureAlgorithm(provider, "SHA512", "CVC-ECDSA", PREFIX + "SignatureSpi$ecCVCDSA512", EACObjectIdentifiers.id_TA_ECDSA_SHA_512);
            //
            // addSignatureAlgorithm(provider, "SHA1", "PLAIN-ECDSA", PREFIX + "SignatureSpi$ecCVCDSA", BSIObjectIdentifiers.ecdsa_plain_SHA1);
            // addSignatureAlgorithm(provider, "SHA224", "PLAIN-ECDSA", PREFIX + "SignatureSpi$ecCVCDSA224", BSIObjectIdentifiers.ecdsa_plain_SHA224);
            // addSignatureAlgorithm(provider, "SHA256", "PLAIN-ECDSA", PREFIX + "SignatureSpi$ecCVCDSA256", BSIObjectIdentifiers.ecdsa_plain_SHA256);
            // addSignatureAlgorithm(provider, "SHA384", "PLAIN-ECDSA", PREFIX + "SignatureSpi$ecCVCDSA384", BSIObjectIdentifiers.ecdsa_plain_SHA384);
            // addSignatureAlgorithm(provider, "SHA512", "PLAIN-ECDSA", PREFIX + "SignatureSpi$ecCVCDSA512", BSIObjectIdentifiers.ecdsa_plain_SHA512);
            // addSignatureAlgorithm(provider, "RIPEMD160", "PLAIN-ECDSA", PREFIX + "SignatureSpi$ecPlainDSARP160", BSIObjectIdentifiers.ecdsa_plain_RIPEMD160);
            // END android-removed
        }
    }
}
