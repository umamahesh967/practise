//package com.database.jpa.hibernate.demo.aws;
//
//import com.amazonaws.auth.AWSCredentialsProvider;
//import com.amazonaws.auth.profile.ProfilesConfigFile;
//import com.amazonaws.auth.profile.internal.AllProfiles;
//import com.amazonaws.auth.profile.internal.BasicProfile;
//import com.amazonaws.auth.profile.internal.ProfileAssumeRoleCredentialsProvider;
//import com.amazonaws.profile.path.AwsProfileFileLocationProvider;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.ListObjectsV2Result;
//import com.amazonaws.services.s3.model.S3Object;
//import com.amazonaws.services.s3.model.S3ObjectInputStream;
//import com.amazonaws.services.s3.model.S3ObjectSummary;
//import com.amazonaws.services.securitytoken.internal.STSProfileCredentialsService;
//import java.io.File;
//import java.util.Arrays;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.io.input.BoundedInputStream;
//
//public class S3ObjectFetch {
//  private static final int DEFAULT_BUFFER_SIZE = 64 * 1024 * 1024;
//
//  public static void main(String[] args) {
//    try {
//      AllProfiles allProfiles = flattenConfigurationFiles(
//          AwsProfileFileLocationProvider.DEFAULT_CONFIG_LOCATION_PROVIDER.getLocation(), // ~/.aws/config
//          AwsProfileFileLocationProvider.DEFAULT_CREDENTIALS_LOCATION_PROVIDER.getLocation() // ~/.aws/credentials
//      );
//      String currentProfileName = "umamahesh";
//      BasicProfile currentProfile = allProfiles.getProfile(currentProfileName);
//      STSProfileCredentialsService profileCredentialsService = new STSProfileCredentialsService();
//      // We stick our merged profile provider first, but we still want the default behavior to apply
//      // so create a new chain with the default chain as the tail provider.
////      AWSCredentialsProvider credentialsProvider = new AWSCredentialsProviderChain(
////          new ProfileAssumeRoleCredentialsProvider(profileCredentialsService, allProfiles, currentProfile),
////          new DefaultAWSCredentialsProviderChain()
////      );
//      AWSCredentialsProvider credentialsProvider =
//          new ProfileAssumeRoleCredentialsProvider(profileCredentialsService, allProfiles, currentProfile);
////      new ProfileCredentialsProvider("umamahesh");
//
//          //below one is used to retrieve the credential suing command, where command is set in currentProfile.setCommand
////      new ProfileProcessCredentialsProvider(currentProfile);
//
//      final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
//          .withCredentials(credentialsProvider)
//          .withRegion(Regions.AP_SOUTH_1).build();
//
//      //get object
//      S3Object s3Object = s3.getObject("umamahesh-bucket", "README.md");
//      S3ObjectInputStream inputStream = s3Object.getObjectContent();
//      BoundedInputStream bis = new BoundedInputStream(inputStream, DEFAULT_BUFFER_SIZE);
//      byte[] content = IOUtils.toByteArray(bis);
//      System.out.println(new String(content));
//
//      //list objects
//      ListObjectsV2Result result = s3.listObjectsV2("umamahesh-bucket");
//      List<S3ObjectSummary> objects = result.getObjectSummaries();
//      for (S3ObjectSummary os : objects) {
//        System.out.println("* " + os.getKey());
//      }
//    }
//    catch (Exception e){
//      System.out.println(e.getMessage());
//    }
//
//  }
//
//
//  private static AllProfiles flattenConfigurationFiles(File firstFile, File... additionalFiles) {
//    // Utilize the AWS SDK to load the actual profile objects
//    List<ProfilesConfigFile> allProfileConfigFiles = Stream.concat(Stream.of(firstFile), Arrays.stream(additionalFiles))
//        .map(ProfilesConfigFile::new).collect(Collectors.toList());
//    // Process each file one by one, look at their profiles, and place their values into a single map
//    // Duplicate profiles will now have the single key/value pairs.
//    Map<String, Map<String, String>> buildingMap = new LinkedHashMap<>();
//    for (ProfilesConfigFile currentConfigFile : allProfileConfigFiles) {
//      for (Entry<String, BasicProfile> currentProfile : currentConfigFile.getAllBasicProfiles().entrySet()) {
//        // Some profiles are prefixed with "profile " so we want to cull it so we're actually merging the correct data
//        String currentProfileName = currentProfile.getKey().replaceAll("^profile\\s+", "");
//        if (!buildingMap.containsKey(currentProfileName)) {
//          buildingMap.put(currentProfileName, new LinkedHashMap<>());
//        }
//        Map<String, String> profileKeyValuePairs = buildingMap.get(currentProfileName);
//        for (Entry<String, String> overridingEntry : currentProfile.getValue().getProperties().entrySet()) {
//          profileKeyValuePairs.put(overridingEntry.getKey(), overridingEntry.getValue());
//        }
//      }
//    }
//    // Take the results, and convert them to AWS SDK Types
//    Map<String, BasicProfile> finalResult = new LinkedHashMap<>();
//    for (Entry<String, Map<String, String>> currentFinalProfile : buildingMap.entrySet()) {
//      String currentProfileName = currentFinalProfile.getKey();
//      finalResult.put(currentProfileName, new BasicProfile(currentProfileName, currentFinalProfile.getValue()));
//    }
//    return new AllProfiles(finalResult);
//  }
//}
