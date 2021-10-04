/*
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

import java.util.List;
import java.util.Queue;

public class SQS {

    private static SendMessageRequest sendMessageRequest(String q, String data){
        return new SendMessageRequest(q,data);
    }

    private static  ReceiveMessageRequest receiveMessageRequest(String q, int hideTimeoutInSeconds){
        return new ReceiveMessageRequest(q)
                .withMaxNumberOfMessages(1)
                .withVisibilityTimeout(hideTimeoutInSeconds);
    }

    public static void main(String[] args) {
        AmazonSQSClient sqs = new AmazonSQSClient(new BasicAWSCredentials("AKIAJPRHUYTS3YY2ZE6A", "wPjoLzXd6VroXC3BqbOjh/2sB6hsBYnYUn2rwS20"));
        String corporate_bill_ledger_queue = "https://sqs.ap-southeast-1.amazonaws.com/503805144375/test";

        List<Message> messages = sqs.receiveMessage(receiveMessageRequest(corporate_bill_ledger_queue, 10)).getMessages();
        if(messages!=null && !messages.isEmpty()){
            com.amazonaws.services.sqs.model.Message sqsMessage = messages.get(0);
        }


        SendMessageResult sendMessageResult = sqs.sendMessage(sendMessageRequest(corporate_bill_ledger_queue, "nalin"));
    }

}
*/
