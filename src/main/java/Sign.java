import com.qoppa.pdf.PDFException;
import com.qoppa.pdf.SigningInformation;
import com.qoppa.pdf.form.SignatureField;
import com.qoppa.pdfSecure.PDFSecure;

import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Sign {

    public static void main(String[] args) throws IOException, PDFException, GeneralSecurityException {
        PDFSecure pdfDoc = new PDFSecure ("/Users/nalinsharma/ola/nalin/src/main/resources/dummy.pdf", null);

// Load the keystore that contains the digital id to use in signing
        FileInputStream pkcs12Stream = new FileInputStream ("/Users/nalinsharma/ola/nalin/src/main/resources/Signer.pfx");
        KeyStore store = KeyStore.getInstance("PKCS12");
        store.load(pkcs12Stream, "ola1234".toCharArray());
        pkcs12Stream.close();

// Create signing information
        //SigningInformation signInfo = new SigningInformation (store, "", "");

// Create signature field on the first page
        Rectangle2D signBounds = new Rectangle2D.Double (36, 36, 144, 48);
        SignatureField signField = pdfDoc.addSignatureField(0, "signature", signBounds);

// Apply digital signature
        //pdfDoc.signDocument(signField, signInfo);

// Save the document
        pdfDoc.saveDocument ("output.pdf");
    }

}
