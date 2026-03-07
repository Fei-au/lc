Three wave of cloud computing

1. Colocation
   Rent physical place, providers provide electricity, network, air condition and more. But  os and software are provided by companies themselives.
2. Virtual Data Center
   Split a physical machine to many virtual machine, each machine contains their os.
3. Container-based Architecture
   Docker and Kubernetes
   Do not need to virtualize a whole computer, but only virtualize the running enviroment for the application.

## IaaS and PaaS

Virtual data center:
Infrastructure as a service

- Raw compute
- Storage
- Network
  Similar to physical data centers
  Computer Engine is an IaaS
  Customer pay the resources ahead of time

Platform as a service

- Bind code to libraries that provide access to the infrasture application needs
  App Engine is an PaaS
    - App Engine, you provide code like python, js, java, and give it to google, they config the compute, storage, network resources and run your code, return you an url.
      Customer pay the resources they acutally use

Cloud Run is another PaaS, a serverless technology, run containerized microservices
Cloud Run functions, manages event-driven codes

SaaS
Provide entire application stack, deliverying entire cloud-based application that customer can use
Like Gmail, Drive

## The Google Cloud network

- Google cloud Run on Google's own global network
- High throughput and low latencies
- Locations cached for quicker access
- Redundant cloud regions to high-bandwidth connectivity
- Seven major geographic locations, each location divided into different regions and zones. For availability, durability, and latency
  - Locations: Asian, North America, Europe...
  - Regions: asia-east1
  - Zones: asia-east1-a, zones are connected by high fiber network


## Security

- Hardware infrastructure layer
  - Hardware design and provenance: customer design data center, chips
  - Secure boot stack: BIOS, bootloader, kernel, OS
  - Permises security
- Service deployment layer
  - encryption of inter-service communication: cryptographic privacy and integrity for remote procedure call (RPC). 
    - Google services communicate with each other using RPC calls
    - Deploy hardware cryptographic accelerators, exntend the default encryption to all RPC traffic inside data centers
- User identity layer
  - Similar location, same device
  - Universal Second factor U2F
- Storage layer
  - Encryption using centrally managed key
  - Enables hardware encryption
- Internet communication layer
  - Google Front End, TSL connections: public-private key pair and CA certificates
  - Denial of Service DoS protections
- Google's Operational security layer
  - Intrusion detection: Rules gives security teams warnings of possible incidents
  - Reducing insider risk: Limits and monitors the activities of employees who access to infrastructure
  - Employee U2F use
  - Stringent software development practices：central source control and two-party review of code

## Billings and pricing

- Rate Quotas: For example, by default, the GKE service implements a quota of 3,000 calls to its API from each Google Cloud project every 100 seconds.
- Allocation quotas: For example, by default, each Google Cloud project has a quota allowing it no more than 15 Virtual Private Cloud networks.

### Resource Manager

Policies contain a set of roles and members, and policies are set on resources.
    
IAM policies are inherited top-to-bottom, billing is accumulated from the bottom up.

Each project is associated with one billing account. and resources cost are accumulated.

Specifically, projects let you enable billing, manage permissions and credentials, and enable services and APIs.

To interact with Google Cloud resources, you must provide the identifying project information for every request. So you know which project pay the cost of the resource usage.

Resource hierarchy:
    From physical organization:
        Global
        Regional
        Zonal

**quotas**
quotas or limits.
Eg:
    - you can only have fifteen VPC networks per project.
    - you can only have 24 CPUs per region.
    
As your use of Google Cloud expands over time, your quotas may increase accordingly.

- prevent runaway consumption in case of error or malicious attack.
- Quotas also prevent billing spikes or surprises.


**labels**
more granularity for resources
key-value pairs that you can attach to your resources, like VMs, disks, snapshots and images.
Used to organize resources, and they can propagate through billing.

- For example, you could create a label to define the environment of your virtual machines. Then search and list all your production resources
- help analyze costs or to run bulk operations on multiple resources.
  Examples:
- cost accounting or budgeting, eg: team:marketing and team:research.
- distinguish components, eg: component:redis, and component:frontend.
- owner or a primary contact for a resource, eg: owner:alice, and owner:bob.
- state, eg: state:inuse, and state:readyfordeletion.


**Network tags**
 user-defined strings that are applied to instances only and are mainly used for networking, such as applying firewall rules and custom static routes.

**billing**
set a budget.

create a budge:
    1. on project name
    2. set amount
    3. email or pub/sub notification
    
labeling all your resources and exporting your billing data to BigQuery to analyze your spend.
    

## Resrouce Monitoring

**Google Cloud Observability**
monitoring logging, error reporting, and fault tracing
    there are free usage allotments
    
**Cloud Monitoring**
Charts
Dashboards
Alerts
    Such as the server down at night
    We recommend alerting on symptoms, and not necessarily causes
    - The type of uptime check can be set to HTTP, HTTPS, or TCP.
    - The resource to be checked can be an App Engine application, a Compute Engine instance, a URL of a host, or an AWS instance or load balancer.
    
Metrics
A metrics scope is the root entity that holds monitoring and configuration information in Cloud Monitoring.

- Every metrics scope is hosted by a specific Google Cloud project, known as the Scoping Project.
- The metrics scope can include the scoping project itself plus up to 375 additional Google Cloud projects. These are called Monitored Projects.
  - By adding projects to a metrics scope, you can view metrics from different environments (like Production, Staging, and Dev) on a single chart without switching project contexts

a role assigned to one person on one project applies equally to all projects monitored by that metrics scope.

In order to give people different roles per project and to control visibility to data, consider placing the monitoring of those projects in separate metrics scopes.

The Ops Agent collects metrics inside the VM, not at the hypervisor level.

The Ops Agent supports most major operating systems, such as CentOS, Ubuntu, and Windows.

When you want to maintain a metric at a target value, specify a utilization target.
The autoscaler creates VMs when the metric value is above the target and deletes VMs when the metric value is below the target.
**Logging**
store, search, analyze, monitor, and alert on log data and events from Google Cloud and AWS.

Logging includes storage for logs, a user interface called Logs Explorer, and an API to manage logs programmatically.

Logs are only retained for 30 days, but you can export your logs to Cloud Storage buckets, BigQuery datasets, and Pub/Sub topics.
BigQuery for analysis
Pub/Sub for real-time processing and alerting

Looker Studio transforms your raw data into the metrics and dimensions that you can use to create easy-to-understand reports and dashboards.

**Partner Integration**
This helps expand the IT ops, security, and compliance capabilities available to Google Cloud customers.

Site Reliability Engineering:
Monitoring!!!

**Error Reporting**

**Tracing**
Cloud Trace is a distributed tracing system that collects latency data from your applications and displays it in the Google Cloud console.

track how requests propagate through your application and receive detailed, near real-time performance insights.

**Profiling**
Cloud Profiler continuously analyzes the performance of CPU or memory-intensive functions executed across an application.
Profiler uses statistical techniques and extremely low-impact instrumentation that runs across all production application instances to provide a complete picture of an application’s performance without slowing it down.

## Multi-zone

- Improve fault tolerance 即便是一个region中的multi-zone，防止单个机房出问题，如火灾等
- Multi-region 成本更高，防止的是地震，战争等

## Googel Cloud's resource hierarchy

Four levels, buttom up. Each resource has exactly one parent

1. Resources
   Like VM, Storage buckets, tables in BigQuery, organized into projects
2. Projects: A trust boundary within your company
   Can be organized into folders

- Basis for enabling and using GC services, APIs, billing...
- Each project is a seperate entity under the organization node
- Each resource belongs to exactly one project
  Identity attributes
- Project ID (95% Identity, global unique), name, number (rarely used, global unique)
  Google Cloud’s Resource Manager tool: the API manages projects
- Even recover projects that were previously deleted,and can be accessed through the RPC API and the REST API

3. folders: Your department
   Have subfolders

- The resources in a folder inherit policies and permissions from the folder
- To use folders, must have an organization node
  Folders:
  - subfolder - department X
    - subfolder - teamA
      - subfolder - product1
      - subfolder - product2
    - subfoler - teamB
      subfolder - department Y

1. Organization node: Your company

- When a user with a Google Workspace or Cloud Identity account creates a Google Cloud project, an organization resource is automatically provisioned for them.
  Policies can be defined at project, folder, organization node levels, some GC services allow polices to be applied to individual resources
- Google Workspace or Cloud Identity super administrator:
  - Assign the Organization Admin role
  - be a point of contact in case of recovery issues
  - control the lifecycle of the Google Workspace or Cloud Identity account
- Organization Admin role:
  - Define IAM policies
  - determine the structure of the resource hierarchy
  - delegate responsibility over critical components, such as networking, billing, and resource hierarchy, through IAM roles.
  - Cannot create folders initially, but can give itself the permission to create folders, and then it is able to do so.
    Policies are inherited downward:
    A policy applied to folder, will applied to its projects within the folder

## IAM

Define who can do what on which resources

- Who (also called principles) of an IAM policies can be

  - a Google account
    - with email as an entity, end user
  - a Google group
    - a named collection of Google Accounts and service accounts
    - has a unique email associate with the group
  - a service Account
    - belong to application instead of end user
    - when run code that is hosted on GC, specify the account that code should run as.
  - a Cloud Identity domain
    - customers who are not Google Workspace customers can get these same capabilities through Cloud Identity
    - Users can be managed by Google Admin console, and IAM is not capable
  - a Google Workspace domain
    - like company.com
    - a virtual group of all the Google Accounts that have been created in an organization's Google Workspace account.
      Identified by email usually

- Can do what defined by a role

  - a collection of permissions
    When you grant role to a principle, you grant all the permissions that the role contains
  - Define deny rules, and apply to certain principle, even it inherit the permission from certion role, it is denied to access the resources as GC check deny rule before permissions
  - Deny policies are inherited through resource hierarchy
    Three kind of roles in IAM

  1. Basic
     1. Owner: access, change and manage associated roles and permissions and set up billing
     2. Editor: access and change, deploy and modify or configure its resources
     3. Viewer: access but not change
     4. Billing administrator
  2. Predefined
     1. InstantAdmin, which manages Compute Engine, apply to principle, folder...
  3. Custom
     1. least-privilege
     2. Can only be defined at project or organization level 
        Best practice:

- Granting roles to groups instead of individuals

- Resource hierarchy

### Policy

A policy is a list of bindings which bind “谁（Principal）在什么资源上拥有什么权力（Role）”
It has to bind with resources

```json
{
  "bindings": [
    {
      "role": "roles/storage.objectViewer",
      "members": [
        "user:alice@example.com",
        "serviceAccount:my-app@project-id.iam.gserviceaccount.com"
      ]
    },
    {
      "role": "roles/compute.admin",
      "members": [
        "group:dev-admins@example.com"
      ]
    }
  ],
  "etag": "BwWW4zdwfNE=",
  "version": 3
}
```

Policy insights to help you do the least priviledge
ML-based findings about permission usage in your project, folder, or organization

### Google Cloud Directory Sync

This tool synchronizes users and groups from your existing Active Directory or LDAP system with the users and groups in your Cloud Identity domain.

### Service accounts

It is an account that belongs to your application instead of to an individual end user.

Eg, compute engine holds a service account, and the service account holds some roles, so the compute engine have access to some resources. So applications running in the compute engine have certion permissions

- service account itself is a resource that can be managed by roles
  Eg, Alice has service accounts create permission, so she can create and set any permissions on the service accounts even the permission Alice does not have like bucket access
  Anothe Eg, Service_Account_1 has InstanceAdmin role, and some users or a group are assigned to Service Account User Role, which means they can manipulate or pretend they are a certain Service Account. So they act as Service_Account_1, and then they can do create, modify action on instance which from InstanceAdmin role.

### IAP Identity-Aware Proxy

Is to project custom applications like (Admin website, internal tools)
Which IAM is to project Cloud Resources which hold those custom applications.

It acts like the authorization step in public website

Tow steps

- Who you are (log in to Cloud Account)
- What can you do (check the account's IAM permissions)

### Cloud Identity

## Virtual Private Cloud Networking

1. Definition & Value
   Concept: A private, isolated network hosted within Google’s public cloud.

​	Hybrid Benefit: Combines scalability (public) with data isolation (private).

2. Core Components
   Connectivity: Connects resources to each other and the internet.

Control Tools: * Firewall Rules: Restrict access to instances.

Static Routes: Forward traffic to specific destinations.

Segmentation: Organizes the network into subnets.

3. Global Architecture (High Probability Exam Topic) ⭐
   VPC Scope: Global. A single VPC can span multiple regions worldwide.

Subnet Scope: Regional. Subnets are defined within a region but can span multiple Zones.

Key Advantage: Resources (VMs) can be in different Zones but belong to the same Subnet.

4. Flexibility & Scaling
   IP Expansion: You can increase subnet size by expanding the IP range.

Zero Downtime: Expanding a subnet does not affect existing, configured VMs.

1. 

Compatibilities:

- Forward traffic from one instance to another within same network, across subnetworks, or between google cloud zones without external IP address
- Firewall, distributed firewall
- VPC Peering, two VPCs can exchange traffic; IAM control who and what in one project can interact with a VPC in another



### Connecting networks to Google VPC

Method 1:
Cloud Virtual Private Network(VPN), the tunnel, connects Cloud VPC and other network like (AWS network or your own data center)

1. VPN is encrypt
2. Cloud Router use Border Gateway Protocol to tell each side the existance of each other (route information). (While Normal case is route table)

Security and bandwidth concerns

Method 2:
Peering, putting a router in the same public data center as a Google point of presence, and exchange traffic

1. networks stay seperate
2. Internal IPs
3. No IP Overlap
4. Transitive Peering is NOT allowed
5. Administration: Each side of the peering must independently agree to the connection (one side "requests," the other "accepts").


Each GC project has a default network


### Service Level Agreement

A Service Level Agreement (SLA) is a documented, formal contract between a service provider and a customer that defines specific, measurable performance metrics (e.g., 99.9% uptime, 4-hour response time).

Network SLA

### Dedicated Interconnect

For solutions where Google has direct control over the physical hardware and the connection termination point.

Peering is to send traffic between your business and Google

Network Tier is to send traffic between Google and end user

### Carrier Peering

Your business === A service Provider === Google
The provider do the handshake with Google
Applicable when your data center location does not have a Google edge location(Points of Presence)
Routes traffic over the public Internet; Google cannot gurantee internet hop performance.

### Direct Peering

Your business === Google
A fiber or logic connection to Google directly
You and Google handshake

Relies on a thrid-party provider's network; your SLA is with the carrier not Google

### Standard Network Tier

Routes traffic over the public Internet; Google not gurantee hop performance.

### Dedicated Interconnect:

Provides physical connection between on-premises network and Google's network.

### Networking subnets

Subnet:

1. Logical Grouping: You don't want your HR database sitting in the same "room" as your public-facing website code. Subnets let you group related resources.
2. Granular Security: You can apply different rules to different subnets.Example: A "Public Subnet" for your website (allows internet traffic). A "Private Subnet" for your Database (blocks ALL internet traffic, only allows the website to talk to it).
3. Geography (Google Specific): In Google Cloud, a VPC is global, but a Subnet is Regional. You create a subnet to define where in the world your resources physically live (e.g., a subnet in Tokyo, another in Iowa).

Subnets are used to manage IP, splite a large network into small chunks, reduce traffic congestion and improve safety.
It uses subnet mask to split IP

Purpose:

- Minimize broadcasting: If a network includes a thousand computers, and each computers is broadcasting, it will ruin the network.
- Security: Split financial and guest Wi-Fi into different subnet, so they cannot access data in each other
- Easy management: Let floor 1 use 192.168.1.x subnet and floor 2 use 192.168.2.x subnet

eg:
web-subnet-us use 10.0.1.0/24 for us VMs
web-subnet-asia use 10.0.2.0/24 for asian VMs
db-subnet-us use 10.0.3.0/24 for Cloud SQL and Storage

The subnet mask is to mask the first N bit, so that masked N bit are a subnet IP range, the rest bits are subnets IPs and can be used by hosts in the subnet
Like 10.0.1.0/24, they masked 10.0.1, so all the hosts in this subnets are IPs start from 10.0.1, and they can be arranged as 10.0.1.0 - 10.0.1.255 IPs except broadcasting, and other normal reserved IP, so maybe totally 250 IPs can be used by hosts in the subnet

Normally IP is public, but there are three IP reserved for subnets

1. 10.0.0.0/8 or 10.0.0.0 - 10.255.255.255 are class A subnet, usually used by big companies
2. 176.16.0.0/16 or 176.16.0.0 - 176.16.255.255 for class B subnet
3. 192.168.0.0/16 or 192.168.0.0 - 192.168.255.255 for class C subnet, usually used by personal home
4. 


## Compute Engine

As a solution of IaaS

Pricing: billed by second with one-minute minimum

Preemptible or Spot VMs:
You can use it with a cheap price, if someone else use it, the VM will let them to use and you will be stopped to use it. 


- High Avilibility and Disaster Recovery.
  eg: application on even Zone fails
  ans: use Regional managed, Multi-Regional

- Updating Applications
  eg: update application on 100 VMs with zero downtime
  ans: Rolling update, provide a new instance, MIG replace one by one

- Storage Performance and Persistence
  eg: lowest latency for disk I/O
  ans: Local SSD

- Security, Shielded vs Conditional VMs
  eg: While it is being processed in memory
  ans: Confidential Computing (COnfidential VMs) Encrypts data in-use (in RAM)

  Shielded VMs: Protect against boot-level malware

- Cost Optimization
  eg: Compute Engine cost too high, CPU use 10%
  ans: Rightsizing Recommendations. GC analyzes usage and suggests smaller machine types
  If workloadis predictable in 1-3 years, use Comminuted use Discounts

- Health-check and Self-Healing
  eg: VM on but application inside was crashed
  ans: Application-level Health Check

Managed Instance Groups (MIGs): Always the answer for scaling and auto-healing.

Instance Templates: You cannot edit a template; you must create a new version and update the MIG.

Metadata & Startup Scripts: Used to configure VMs automatically when they boot up.

IP Addresses: Use Alias IP ranges if you are running containers (like GKE) on your VMs.

## Cloud Load Balancing

Senario: 40 VMs handle requests
Distribute user traffic across multiple instances of an application

- Fully-distributed, software-defined
- In front of HTTP, HTTPS, TCP, SSH, UDP
- cross-region load balancing

Application Load Balancer

- works on application layer, for HTTP and HTTPS
- reverse proxies
- internet facing and internal application

Network Load Balancer

- works on transport layer
- TCP, UDP, other IP protocols
  1. Proxy NLB
     1. reverse proxies, terminating client connections and establishing new ones to backend services
  2. Passthrough NLB
     1. do not modify or terminate connections
     2. forward traffic and preserving original source IP address
     3. wider range of IP protocols  

## Cloud DNS and Cloud CDN

8.8.8.8 Domain Name Service
Translate internet hostname to addresses

Cloud DNS help to find hostnames and addresses built in Coogle Cloud

Content Delivery Network:

Edge caching refers to use caching servers to store content closer to end users

1. 

## Cloud Storage

### Defination

- website, archival, disaster recovery, distributing large data objects allow user direct download
- Not a file
- A collection of bucket that you place objects into
- Directories are is just another object

### Four classes

- Standard
  - eg: website, streaming video, data for mobile or gaming applications
  - freqently accessed, hot data, or stored for brief period of time
  - most expensive
  - **no minimum duration**
  - no retrieval cost
  - select the same location as GKE or CE to save the data, maximize the performance for data-intensive computations and reduce network charges
  - if in multi or dual region, it improves availability and is appropriate for data that is accessed around the world 
- Nearline
  - low cost, highly durable
  - infrequently accessed data like data backup, long-tail multimedia content and data archiving
  - **30-day** minimum storage duration
  - higher price than standard storage for data access and lower price for data storage 
- Codeline
  - very-low-cost, highly durable for storing infrequently accessed data
  - slightly low availability
  - **90-day** minimum storage duration
  - Higher cost than above two storages for data access and lowercost for storage
- archive 
  - lowest-cost, highly durable for data archiving, online backup, disaster recovery
  - **365-day** minimum storage

Auto class: transitions objects to appropriate storage classes

### Each provides three location types

- Multi-region
- Dual-region
- A Region
  The first two are geo-redundant

You can change data storage type of a bucket as well as an object but cannot change the location types

### Access control:

- IAM, roles, for view, create buckets or objects
- Access control lists or ACL for finer control. 
  - Who can access the buckets or objects, 
  - maximum 100 ACL
  - one ACL consists of more entries
  - entries consists of two information:
    - A scope: **who** can perform the specific action (a user, a group)
    - A permission: **what actions** can be performed (read, write)
    - Allusers: everyone on the Internet is allowed
    - allAuthenticatedUsers: anywho who is authenticated with a Google account
- Signed URL provides a cryptographic key that give time-limited access to a bucket or object
  - Not using account-based authentication
- Signed policy document more finer: what file can be uploaded by people with a signed URL

### Object Lifecycle Management:

You set a few rules, and the system handles the cleanup or moving of files for you.
Benefit:

- Cost Optimization
- Compliance, like deleting user data after certain period
- Less Human Error
  "If This, Then That" logic
- Condition: "Is this file older than 365 days?" or "Is there a newer version of this file?"
- Action: e.g., "Delete it" or "Move it to a cheaper storage tier."
  Act asynchronize, so after update the rule, it may take 24 hours to be valid

### Object Versioning

Can be enabled for a bucket

Create an archived version of an object 
archived version identified by generation number

Soft Delete:

- use Soft Delete instead of Object Versioning to protect against permanent data loss
- Soft Delete retains all deleted objects whether by overwriting, changing of the data

### Retention Lock

A retention configuration governs how long the object must be retained and has the option to permanently prevent the retention time from being reduced or removed.

### Upload large file to Storage

- Transfer Appliance
  - Hardware appliance
- Storage Transfer Service
  - import online data
- Offline Media Import
  - physical media is sent to a provider who uploads the data

Uploads are strongly consistent, never 404 or data inconsistent like read write problem

Deletions are global consistency, so after delete an object, immediately access the data will response 404

Bucket listing is strongly consistent

Object listing is also strongly consistent

### Directory Synchronization

Sync a VM directory with a bucket

## Cloud SQL

No global Scalability

fully managed service of either MySQL, PostgreSQL, or Microsoft SQL Server databases

patches and updates are automatically applied

High Availability configuration:

  - a primary instance and a standby instance 
  - synchronous replication to each zone's persistent disk, all writes made to the primary instance are replicated to disks in both zones before a transaction is reported as committed.
  - failover: In the event of an instance or zone failure, the persistent disk is attached to the standby instance, and it becomes the new primary instance.
  - automated and on-demand backups
  - Disadvantage: 
  - scale up, which does require a machine restart or scale out using read replicas. 
  - horizontal scalability using spanner 
    Connection:
  - Private IP connection: within the same Google Cloud project
  - Outside Google Cloud project or publicly connect to it:
    - Cloud SQL Auth Proxy, which handles authentication, encryption, and key rotation for you
    - SSL connection
    - authorizing a specific IP address to connect to your SQL server over its external IP address

## Spanner

horizontal scalability

全球级、强一致性的分布式关系型数据库
Like Relational DB

- Has schema, SQL, strong consistency
  Like Non-Relational DB
- high availability, horizontal scalability, and configurable replication.

A Spanner instance replicates data in N cloud zones, which can be within one region or across several regions.
The replication of data will be synchronized across zones using Google's global fiber network.

## Firestore

**Non-relational**
highly-scalable, NoSQL database
fully managed, **serverless**, cloud-native, NoSQL, **document database**


simplifies storing, syncing and querying data for your mobile, web, and IoT apps at global scale.

ACID transactions

Firestore even allows you to run sophisticated queries against your NoSQL data without any degradation in performance.

Firestore in Datastore mode for new server projects, and Native mode for new mobile and web apps.

- **No-SQL Non-relational**: Schema might change
- **Serverless**: Adaptable database, scale to zero
- low maintenance overhead
- transactional consistency
  If not transactional consistency, could consider Bigtable

**Document database**

Work with compute engine fleets, so they could have a shared file system.

- Application migration
- Media rendering
- Electronic Design Automation EDA
- Data analytics
  - without the need to lose valuable time on loading an offloading data to clients drives
- Genome sequencing 


## AlloyDB

**Relational**
For PostgreSQL, fully managed

- automates administrative tasks, such as backups, replication, patching and capacity management
- fast transactional processing
- enterprise workloads: high transaction throughput, large data sizes, or multiple read replicas.
  Need hybrid transactional and analytical processing (HTAP)

## Bigtable

Analytics

fully managed NoSQL database with petabyte-scale and very low latency

Perational and analytical applications, including IoT, user analytics, and financial data analysis, machine learning applications

Support open source industry standard HBase API

In Bigtable, data is indexed by a Row Key, a Column Family, a Column Qualifier, and a Timestamp.

1. Row key: Like the unique id in SQL
   Example: USER#12345

2. Column family: Like a table in SQL, and each row can have many tables, or families. Related columns together and are defined at the schema level
   Example: Family A: profile
           Family B: interactions

3. Column Qualifiers: Like a field in a SQL table, or dynamic and can be anything
   Under profile: display_name, country
   Under interactions: last_login, total_posts

4. Timestamps & Versioning


Bigtable is sparse, if "Bob" doesn't have a total_posts qualifier, it takes up zero space. There are no "NULL" values like in a SQL database.

**Tablets**
Bigtable doesn't store a whole table as one giant file. It chops your table into chunks of rows called Tablets    

**Nodes and Load Balancing**
It learns to adjust to specific access patterns based on workload.
Node: is like a VM or Compute instance that serves many tablets.

When a node is frequently accesssing a certain subset of data --- a tablet,
it will split the tablet into smaller tablets and move some of it to another node.
And update the index to point to the new location.
In this way, other nodes can distribute that workload.

so for every single node that you do add, you're going to see a linear scale of throughput performance, up to hundreds of nodes.
Each node you add will not be staled, it will be active and serving traffic, and you can see a linear increase in performance as you add more nodes.



**NoSQL** wide-column database

low latency, large numbers of reads and writes, and maintaining performance at scale.

Bigtable is also suited as a ‘fast lookup’ **non-relational** database

Row-level consistency

## BigQuery

Analytics

as a data warehouse, is the default storage for **tabular / relational** data, and is optimized for large-scale, ad-hoc SQL-based analysis and reporting.

it has a built-in cache, BigQuery works really well in cases where the data does not often change.

## Memorystore

**Non-relational**

Google Cloud's fully managed Redis service, **cache storage**

- have large spikes in traffic
- gaming environments and real-time analytics

- are replicated across two zones





























