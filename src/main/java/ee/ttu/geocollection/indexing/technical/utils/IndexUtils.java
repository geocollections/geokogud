package ee.ttu.geocollection.indexing.technical.utils;

import org.apache.lucene.index.DirectoryReader;

import java.io.IOException;

//TODO: dirty hack, it should update inly when it is needed, not always, as here (we pass singleton reader which was created on app startup)
public class IndexUtils {
    public static DirectoryReader createDirectoryReader(DirectoryReader directoryReader) {
        try {
            DirectoryReader indexReaderUpdated = DirectoryReader.openIfChanged(directoryReader);
            if (indexReaderUpdated != null) {
                return indexReaderUpdated;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return directoryReader;
    }
}
