#�Q�l�T�C�g

https://www.techscore.com/tech/Java/JavaSE/Thread/index/
https://java.keicode.com/lang/multithreading-executor.php


# 0.intro
### java�X���b�h�̊�{

- �}���`�X���b�h�͂ǂ�Ȏ��Ɏg����?
    - GUI�A�v���P�[�V����
        - ����������X���b�h�ƁA���~�{�^���������ꂽ��A���m���Č����𒆎~������X���b�h
    - ���Ԃ�������I/O����
        - I/O������S������X���b�h�ƁAI/O�����Ɉˑ������A���s�ł����Ƃ��ʂɐi�߂Ă����X���b�h
    - �����̃N���C�A���g
    
- �}���`�X���b�h�ŁA�e�X���b�h���������Ă���Ƃ��A�v���O�����̏I���n�_�͂ǂ��H
    - java�̃v���O�������I������̂́A�f�[�����X���b�h���������S�ẴX���b�h���I�������Ƃ�
        - ex.)���C���X���b�h����L�b�N�����}���`�X���b�h�̍�Ƃ��I���Ȃ��ƁA�����烁�C���X���b�h���̍�Ƃ��I����Ă��v���O�����͏I���Ȃ�
        - ���܂�)setDeamo���]�b�g�ɂ��A�ΏۃX���b�h���f�[�����X���b�h�����邱�Ƃ��\
    - �X���b�h�̏�ԑJ��(.getStatus)
        - (����)����
        - ���s�\/���s���
        - �҂����
        - ���b�N���
        - �I�����
   

- ��� 1-2,1-3

### �}���`�X���b�h�v���O�����̕]���

- (�K�{)���S��
    - �I�u�W�F�N�g���݌v�҂̈Ӑ}�Ƃ͈قȂ��ԂɂȂ�Ȃ�����
- (�K�{)������
    - �K�v�ȏ����͂����K������Ɏ��s����邱��
- �ė��p��
  
- �p�t�H�[�}���X
    - �X���[�v�b�g(�P�ʎ��ԓ�����̏�����)
    - ������(�v�����o���Ă��甽�����Ԃ�܂ł̎���)
    - �L���p�V�e�B(�����ɏ����ł��鐔)
    - ���̑�(�X�P�[���r���e�B etc)
- ��


# 1.single threaded execution - ���̋���n���͈̂�l

|�����b�g|�f�����b�g|
|-----|-----|
|����/�s�������������Ȃ� | |

- �܂Ƃ�(P.481)
<img width="402" alt="SingleThreadExection_pattern.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/f1e828a8-a45e-bf0b-1c00-cea978dad9fe.png">


- ���R���N�V�����N���X���X���b�h�Z�[�t�ɂ��郁�]�b�g(No.102 synchroniedMap ,etc)
- �f�b�g���b�N������������� P.64
    - ���������. ���L�ϐ����Ώۂł��遨��Ώ̂ɂ��� P.475

# immutable - �󂵂����Ă��󂹂Ȃ�

|�����b�g|�f�����b�g|
|-----|-----|
|����/�s�������������Ȃ�����r������s�v | |


<img width="405" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/8887b3d4-ca69-574c-de02-ee1e9d17310c.png">

# Guarede Suspension - �p�ӂł���܂ő҂�

- �C���^���X������OK�ƂȂ�܂ŁA�X���b�h�����]�b�g�����s���Ȃ��悤�ɂ���

|�����b�g|�f�����b�g|
|-----|-----|
|�C���X�^���X���s�����ȏ�ԂɂȂ�̂�h�� | |


<img width="400" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/a03d5b99-d321-be0f-96f6-50f221392941.png">

<img width="383" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/ae72e5e3-ad68-8add-bec0-b33059e85dc7.png">


# Balking - �K�v�Ȃ�������A��߂�

- �C���X�^���X�����҂�����ԂɂȂ��Ă��Ȃ�������A���\�b�h�̎��s�𒆒f����

|�����b�g|�f�����b�g|
|-----|-----|
|���ʂȑҋ@��ߏ�ȃ��\�b�h���s��h�� | |




<img width="406" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/f053451a-1fa3-957d-0fcc-6f50eed5bf19.png">
<img width="417" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/e52daa6a-98ec-ea63-d64f-029edeea82ed.png">

# Producer-Counsumer �������A���Ȃ����g��

|�����b�g|�f�����b�g|
|-----|-----|
|�����̃X���b�h���������ē��� | |


<img width="400" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/3f8e5ec7-d7bd-f747-d881-d32afb573d49.png">

<img width="404" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/a9cd85e7-72e0-d17a-998f-bc82088082ab.png">

# Read-Write Lock �F�œǂ�ł������ǁA�ǂ�ł���Ԃ͏������݋֎~

|�����b�g|�f�����b�g|
|-----|-----|
|�_��Ȕr������ | |



<img width="400" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/39c8f241-f829-cfb3-ddb3-33ebae873a36.png">

<img width="352" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/9256aa19-448f-32a9-4251-43dc1abdcfec.png">

<img width="367" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/736ad095-cb55-c3d3-033e-5f970986bb65.png">



# 7.Thread-Per-Messeage ���̎d���A����Ƃ��Ă�

|�����b�g|�f�����b�g|
|-----|-----|
|�ʂ̃X���b�h�Ɏd����C���āA�����͂������̍�Ƃɐi�ނ��Ƃ��ł��� | |


<img width="395" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/2f75f685-7ddf-eff9-1462-6b95cfbf6c76.png">






# 8.Worker Thread �d������܂ő҂��A�����瓭��

- �X���b�h�v�[�����p

|�����b�g|�f�����b�g|
|-----|-----|
| �X���b�h�̐����I�[�o�[�w�b�h��}�����| |

<img width="405" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/e55a2415-3df4-fa42-5793-115a25f950ab.png">


<img width="363" alt="�d�v.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/200da11d-a282-5d20-1122-01dfe5b80886.png">




<img width="367" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/e36bb549-1426-54e8-d2f5-b4bf8989070f.png">






# 9.Future 

- �ʃX���b�h�ɔC���Ă������d���̌��ʂ𓯊��I�Ɏ󂯎��(�񓯊�)

|�����b�g|�f�����b�g|
|-----|-----|
| �񓯊������̌Ăяo���ɖ𗧂�| |


<img width="416" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/285a7704-6385-f99c-33de-3614fb27107b.png">


<img width="373" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/c2d9b141-6ef1-7670-b014-6c7735db0e80.png">


<img width="375" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/72240b21-31e4-cc52-7847-7e11580c4fd6.png">


<img width="366" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/c99f8c00-89af-0ecf-b344-4e7aa51754b6.png">















# 10.Two-Phase Terminaiton �����ƌ�Еt�����Ă���A�o�C�o�C


|�����b�g|�f�����b�g|
|-----|-----|
| ���S�ɃX���b�h���I��| |

<img width="403" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/7e9ed1fa-950c-8feb-7e16-47c2c83442cf.png">

# 11. Thread-Specific Storege �X���b�h���Ƃ̃R�C�����b�J�[

- �X���b�h���Ƃɕϐ��̈���m�ۂ���


|�����b�g|�f�����b�g|
|-----|-----|
| �r�����䂪�s�v| |

<img width="399" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/762774cc-add6-74d7-7248-9e413e9c4bcd.png">

<img width="372" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/17697896-7d05-93c0-7fd8-e39d1b440d89.png">


# 12.Active Object �񓯊����b�Z�[�W���󂯎��A�\���I�I�u�W�F�N�g


|�����b�g|�f�����b�g|
|-----|-----|
| | |





![uploading-0]()




<img width="395" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/44c98b12-f084-9654-3ffd-4564acd81650.png">



<img width="374" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/e0c687dd-3c11-654a-b2d2-2e21d457f128.png">


# �t�^�Fjava�X���b�h�̗D��x

<img width="395" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/fe115249-e6ea-4a86-b0f3-710de2c62387.png">

# �X���b�h�֘A��API



<img width="399" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/a8509874-f0ac-b960-52aa-35d89519faf4.png">

# java.util.concurrent



<img width="399" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/ca00c943-e732-8d7d-04d3-e0574e379468.png">



<img width="370" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/ce58e3c7-1b09-534b-76c4-8521d399f7cf.png">

<img width="367" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/cf458e6c-af41-a2e6-6fbc-0ab3048f9b1d.png">



<img width="365" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/dda4b92d-a7d7-05cd-ce0e-72d2cf6769ac.png">
<img width="368" alt="�L���v�`��1.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/853c8f03-f112-b3bd-5430-2a20e2691cda.png">



<img width="376" alt="�L���v�`��.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/47b59cfd-be6a-8fe8-b230-c89bf715cb7f.png">



<img width="396" alt="�L���v�`��1.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/a698996f-b75e-5b44-881e-2aea16d23000.png">






